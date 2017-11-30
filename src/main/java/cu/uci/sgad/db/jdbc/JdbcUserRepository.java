package cu.uci.sgad.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cu.uci.sgad.db.repository.UserRepository;
import cu.uci.sgad.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcUserRepository implements UserRepository {

    private static final String INSERT_USER;
    private static final String SELECT_USER_BY_ID;
    private static final String SELECT_USERS;
    private static final String UPDATE_USER_BY_ID;
    private static final String DELETE_USER_BY_ID;


    static {
        INSERT_USER = "INSERT INTO USER (username, password, email, rol) values(?, ?, ?, ?)";
        SELECT_USER_BY_ID = "SELECT id, username, password, email, rol FROM USER WHERE id = ?";
        SELECT_USERS = "SELECT * FROM USER WHERE ID < ? ORDER BY ID ASC LIMIT ?";
        UPDATE_USER_BY_ID = "UPDATE USER SET USERNAME = ?, PASSWORD = ?, EMAIL = ?, ROL = ? WHERE USERNAME = ?";
        DELETE_USER_BY_ID = "DELETE FROM USER WHERE ID = ?";
    }


    private JdbcOperations jdbcOperations;


    @Autowired
    public JdbcUserRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    /**
     * Almacena un usuario en una base de datos.
     *
     * @param user Datos del usuario.
     */
    @Override
    public void addUser(User user) {
        jdbcOperations.update(INSERT_USER, user.getUsername(), user.getPassword(), user.getEmail(), user.getRol());
    }

    @Override
    public User findOneById(long id) {
        return jdbcOperations.queryForObject(SELECT_USER_BY_ID, this::mapFilter, id);
    }

    private User mapFilter(ResultSet resultSet, int rowNum) throws SQLException {
        return new User(
                resultSet.getLong("id"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getString("rol")
        );
    }

    /**
     * Devuelve toda la informacion de cada usuario
     *
     * @param max   el maximo ID de cualquier usuario que se devuelva como resultado
     * @param count cantidad de usuarios que se dara en la respuesta
     * @return usuarios registrados en el sistema.
     */
    @Override
    public List<User> findUsers(long max, int count) {
        return jdbcOperations.query(SELECT_USERS, new UserRowMapper(), max, count);
    }

    private static final class UserRowMapper implements RowMapper<User>
    {

        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new User(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("rol")
            );
        }
    }

    /**
     * Actualiza los datos de un usuario registrado en el sistema
     *
     * @param username          identificador del usuario.
     * @param userData          la informacion a actualizar del usuario actual registrado
     */
    @Override
    public void updateUserById(String username, User userData) {
        jdbcOperations.update(UPDATE_USER_BY_ID
                ,userData.getUsername()
                ,userData.getPassword()
                ,userData.getEmail()
                ,userData.getRol()
                ,username
        );
    }

    /**
     * Elimina un usuario del sistema
     *
     * @param id identificador del usuario a aliminar
     */
    @Override
    public void deleteById(long id) {
        jdbcOperations.update(DELETE_USER_BY_ID, id);
    }

}
