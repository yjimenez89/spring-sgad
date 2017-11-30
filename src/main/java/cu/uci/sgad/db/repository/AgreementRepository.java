package cu.uci.sgad.db.repository;

import cu.uci.sgad.domain.Agreement;


public interface AgreementRepository {

    /**
     * Almacena los datos de un acuerdo
     *
     * @param agreement datos del acuerdo
     */
    void addAgreement(Agreement agreement);

    /**
     * Devuelve los datos de un acuerdo dado el id
     *
     * @param id identificador unico del acuerdo en el almacen de datos
     * @return datos de un acuerdo
     */
    Agreement findOneById(long id);
}
