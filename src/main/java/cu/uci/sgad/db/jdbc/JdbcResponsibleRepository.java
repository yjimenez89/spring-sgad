package cu.uci.sgad.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cu.uci.sgad.db.repository.ResponsibleRepository;
import cu.uci.sgad.domain.Responsible;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcResponsibleRepository implements ResponsibleRepository {

    private static final String INSERT_RESPONSIBLE;
    private static final String SELECT_RESPONSIBLE_BY_ID;


    static {
        INSERT_RESPONSIBLE = "INSERT INTO RESPONSIBLE (NAME, LASTNAME, OCUPATION, EMAIL, AGREEMENTID) values(?, ?, ?, ?, ?)";
        SELECT_RESPONSIBLE_BY_ID = "SELECT ID, NAME, LASTNAME, OCUPATION, EMAIL, AGREEMENTID FROM RESPONSIBLE WHERE ID=?";
    }


    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcResponsibleRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    /**
     * Almacena los datos de un responsable
     * @param responsible datos de un responsable.
     */
    @Override
    public void addResponsible(Responsible responsible) {
        jdbcOperations.update(INSERT_RESPONSIBLE,
                responsible.getName(),
                responsible.getLastName(),
                responsible.getOcupation(),
                responsible.getEmail(),
                responsible.getAgreementId()
        );
    }

    /**
     * Devuelve los datos de un responsable dado de id
     * @param id identificador del usuario.
     * @return los datos de un responsable
     */
    @Override
    public Responsible findOneById(long id) {
        return jdbcOperations.queryForObject(SELECT_RESPONSIBLE_BY_ID, this::mapFilter, id);
    }

    private Responsible mapFilter(ResultSet resultSet, int rowNum) throws SQLException{
        return new Responsible(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("lastname"),
                resultSet.getString("ocupation"),
                resultSet.getString("email"),
                resultSet.getLong("agreementid")
        );
    }
}
