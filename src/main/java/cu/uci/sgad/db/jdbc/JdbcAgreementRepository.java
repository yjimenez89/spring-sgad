package cu.uci.sgad.db.jdbc;

import cu.uci.sgad.db.repository.AgreementRepository;
import cu.uci.sgad.domain.Agreement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcAgreementRepository implements AgreementRepository{

    private final static String INSERT_AGREEMENT;
    private final static String SELECT_AGREEMENT_BY_ID;


    static {
        INSERT_AGREEMENT = "INSERT INTO AGREEMENT(ID, TITLE, DESCRIPTION, DATE_COMPLIANCE, OBSERVATION, STATE) VALUES(?, ?, ?, ?,?)";
        SELECT_AGREEMENT_BY_ID = "SELECT ID, DESCRIPTION, DATE_COMPLIANCE, OBSERVATION, STATE FROM AGREEMENT WHERE ID=?";
    }


    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcAgreementRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    /**
     * Almacena los datos de un acuerdo
     *
     * @param agreement datos del acuerdo
     */
    @Override
    public void addAgreement(Agreement agreement) {
        jdbcOperations.update(INSERT_AGREEMENT,
                agreement.getId(),
                agreement.getTitle(),
                agreement.getDescription(),
                agreement.getDate_compliance(),
                agreement.getObservation(),
                agreement.getState());
    }

    /**
     * Devuelve los datos de un acuerdo dado el id
     *
     * @param id identificador unico del acuerdo en el almacen de datos
     * @return datos de un acuerdo
     */
    @Override
    public Agreement findOneById(long id) {
        return null;
    }
}
