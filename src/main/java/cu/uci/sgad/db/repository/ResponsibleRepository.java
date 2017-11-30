package cu.uci.sgad.db.repository;

import cu.uci.sgad.domain.Responsible;


public interface ResponsibleRepository {

    /**
     * Almacena los datos de un responsable
     *
     * @param responsible datos de un responsable.
     */
    void addResponsible(Responsible responsible);

    /**
     * Devuelve los datos de un responsable dado de id
     *
     * @param id identificador del usuario.
     * @return
     */
    Responsible findOneById(long id);
}
