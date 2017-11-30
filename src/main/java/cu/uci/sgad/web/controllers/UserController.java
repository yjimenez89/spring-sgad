package cu.uci.sgad.web.controllers;

import java.util.List;

import cu.uci.sgad.db.repository.UserRepository;
import cu.uci.sgad.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static String INFO_MESSAGE = "infoMessage";

    private UserRepository userRepository;


    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerUserForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(User user) {
        userRepository.addUser(user);
        return "redirect:/user/" + INFO_MESSAGE + "/" + user.getUsername();   // manejar peticion /user/infoMessage/{username}
    }

    @RequestMapping(value = "/infoMessage/{username}", method = RequestMethod.GET)
    public String showInfoMessage(@PathVariable String username, Model model) {
        model.addAttribute("type", "registerUser");
        model.addAttribute("registeredUser", username);
        return "infoMessage";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String registeredUsers(Model model) {
        List<User> registeredUsers = userRepository.findUsers(Long.MAX_VALUE, 4);
        model.addAttribute("userList", registeredUsers);
        return "registeredUsers";
    }

    @RequestMapping(value = "/delete/{iduser}", method = RequestMethod.GET)
    public String deleteOneUser(@PathVariable String iduser, Model model) {
        long id = Integer.parseInt(iduser);
        User auxUser = userRepository.findOneById(id);
        userRepository.deleteById(id);
        model.addAttribute("deletedUser", auxUser.getUsername());
        return "infoMessage";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateDataOfUser(User user) {
        userRepository.updateUserById(user.getUsername(), user);
        return "infoMessage";
    }
}
