package util;

import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.DBConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.Arguments;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class JdbcTest {
    private static final DBConnection connection = DBConnection.getInstance();
    private static boolean initialized = false;
    @BeforeAll
    static void setup() throws SQLException {
        if (!initialized) {
            connection.executeScript("schemaNFFtest.sql");
            connection.executeScript("dataNFFtest.sql");
            connection.getConnection().setAutoCommit(false);
            initialized = true;
        }
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.getConnection().rollback();
    }
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }
}
