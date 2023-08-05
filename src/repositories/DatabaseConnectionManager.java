package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import exceptions.DatabaseConnectionException;

public class DatabaseConnectionManager {
    private static final String DATABASE_URL= "jdbc:mysql://localhost:3306/joshnick_wallet?createDatabaseIfNotExist=true";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "loveofGod_29";



    private DatabaseConnectionManager(){}

    public static Connection connect() {
        try {

            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            return connection;
        }catch (SQLException exception){
            System.err.println("Error:: "+ exception.getMessage());
            throw new DatabaseConnectionException(exception.getMessage());
        }

    }
}
