package cu.uci.sgad.db.repository;

import java.util.List;

import cu.uci.sgad.domain.User;

public interface UserRepository {

    /**
     * Almacena un usuario en una base de datos.
     *
     * @param user Datos del usuario.
     */
    void addUser(User user);

    /**
     * Devuelve los datos de algun usuario dado su id.
     *
     * @param id del usuario a buscar
     * @return un usuario.
     */
    User findOneById(long id);

    /**
     * Devuelve toda la informacion de cada usuario
     * @param max el maximo ID de cualquier usuario que se devuelva como resultado
     * @param count cantidad de usuarios que se dara en la respuesta
     * @return usuarios registrados en el sistema.
     */
    List<User> findUsers(long max, int count);

    /**
     * Actualiza los datos de un usuario registrado en el sistema
     * @param username identificador del usuario.
     * @param userData la informacion a actualizar del usuario actual registrado
     */
    void updateUserById(String username, User userData);

    /**
     * Elimina un usuario del sistema
     * @param id identificador del usuario a aliminar
     */
    void deleteById(long id);

}
