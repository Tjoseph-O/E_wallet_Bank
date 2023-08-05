import org.junit.jupiter.api.Test;
import repositories.DatabaseConnectionManager;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionManagerTest {
    @Test
    public void testDatabaseConnection(){


        Connection connection = DatabaseConnectionManager.connect();
        System.out.println("Connection:: " + connection);
        assertNotNull(connection);

    }
}
