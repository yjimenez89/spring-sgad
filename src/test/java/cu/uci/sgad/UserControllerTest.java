package cu.uci.sgad;

import java.util.ArrayList;
import java.util.List;

import cu.uci.sgad.db.repository.UserRepository;
import cu.uci.sgad.domain.User;
import cu.uci.sgad.web.controllers.UserController;

import org.apache.commons.logging.Log;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class UserControllerTest {

    @Test
    public void showRegistrationForm() throws Exception {
        UserRepository mockUserRepository = mock(UserRepository.class);

        UserController controller = new UserController(mockUserRepository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/forms/registerUserForm.jsp")).build();

        mockMvc.perform(get("/user/register"))
                .andExpect(view().name("registerUserForm"));
    }

    @Test
    public void processRegistration() throws Exception {
        UserRepository mockUserRepository = mock(UserRepository.class);
        UserController controller = new UserController(mockUserRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/user/register")
                .param("username", "yjimenez")
                .param("password", "1")
                .param("email", "yjimenez@uci.cu")
                .param("rol", "Administrador")
        ).andExpect(redirectedUrl("/user/infoMessage/yjimenez"));
    }

    @Test
    public void showInfoMessage() throws Exception {
        String expectedUsername = "yjimenez";
        UserRepository mockUserRepository = mock(UserRepository.class);
        UserController controller = new UserController(mockUserRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/messages/infoMessage"))
                .build();

        mockMvc.perform(get("/user/infoMessage/yjimenez"))
                .andExpect(view().name("infoMessage"))
                .andExpect(model().attributeExists("type"))
                .andExpect(model().attributeExists("registeredUser"))
                .andExpect(model().attribute("registeredUser", expectedUsername));
    }

    @Test
    public void findUsers() throws Exception {
        List<User> expectedUserList = createUserList();
        UserRepository mockRepository = mock(UserRepository.class);

        when(mockRepository.findUsers(Long.MAX_VALUE, 4)).thenReturn(expectedUserList);

        UserController controller = new UserController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/datas/registeredUsers"))
                .build();

        mockMvc.perform(get("/user/users"))
                .andExpect(view().name("registeredUsers"))
                .andExpect(model().attributeExists("userList"))
                .andExpect(model().attribute("userList", hasItems(expectedUserList.toArray())));
    }

    private List<User>  createUserList() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("yjimenez", "1", "yjimenez@uci.cu", "Administrador"));
        userList.add(new User("yjimeneza", "1", "yjimenez@uci.cu", "Administrador"));
        userList.add(new User("yjimenezb", "1", "yjimenez@uci.cu", "Administrador"));
        userList.add(new User("yjimenezc", "1", "yjimenez@uci.cu", "Administrador"));
        return userList;
    }

    @Test
    public void updateUserById() throws Exception {
        UserRepository mockRepository = mock(UserRepository.class);
        UserController controller = new UserController(mockRepository);
        MockMvc mockMvc = standaloneSetup( controller )
                .setSingleView(new InternalResourceView("/WEB-INF/views/messages/infoMessage"))
                .build();

        mockMvc.perform( post("/user/update")
                        .param("username", "yjimenez")
                        .param("password", "123")
                        .param("email", "yjimenez@uci.cu")
                        .param("rol", "Administrador")
        ).andExpect(view().name("infoMessage"));
    }

    @Test
    public void deleteUserById() throws Exception {
        User expectedUser = new User(2L, "yjimenez", "123", "yjimenez@uci.cu", "Administrador");
        UserRepository mockRepository = mock(UserRepository.class);
        UserController controller = new UserController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/messages/infoMessage"))
                .build();

        mockMvc.perform(get("/user/delete/2"))
                .andExpect(view().name("infoMessage"))
                .andExpect(model().attributeExists("deletedUser"))
                .andExpect(model().attribute("deletedUser", hasItems()));
    }
}
