package cu.uci.sgad.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

@Component
public class TableInitializer {

    private final String CREATE_TABLE_USER;

    private final String CREATE_TABLE_AGREEMENT;

    private final String CREATE_TABLE_RESPONSIBLE;

    {
        CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS USER" +
                "(" +
                "  id INT PRIMARY KEY AUTO_INCREMENT," +
                "  username VARCHAR(255), " +
                "  password VARCHAR(255)," +
                "  email VARCHAR(255)," +
                "  rol VARCHAR(255)," +
                ")";

        CREATE_TABLE_AGREEMENT = "CREATE TABLE IF NOT EXISTS AGREEMENT\n" +
                "(\n" +
                "  id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "  title VARCHAR(255) NOT NULL,\n" +
                "  description VARCHAR(255) NOT NULL,\n" +
                "  date_compliance DATE NOT NULL,\n" +
                "  observation VARCHAR(255),\n" +
                "  state VARCHAR(255)\n" +
                ");";

        CREATE_TABLE_RESPONSIBLE = "CREATE TABLE IF NOT EXISTS  RESPONSIBLE\n" +
                "(\n" +
                "  id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "  name VARCHAR(255),\n" +
                "  lastname VARCHAR(255),\n" +
                "  ocupation VARCHAR(255),\n" +
                "  email VARCHAR(255),\n" +
                "  agreementid INT NOT NULL ,\n" +
                "  CONSTRAINT BLA FOREIGN KEY (agreementid) REFERENCES AGREEMENT (ID)\n" +
                ");";

    }

    private JdbcOperations jdbcOperations;

    @Autowired
    public TableInitializer(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private void createTables() {
        jdbcOperations.execute(CREATE_TABLE_USER);
        jdbcOperations.execute(CREATE_TABLE_AGREEMENT);
        jdbcOperations.execute(CREATE_TABLE_RESPONSIBLE);
    }
}
