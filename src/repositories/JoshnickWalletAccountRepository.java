package repositories;

import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoshnickWalletAccountRepository implements AccountRepository{



    @Override
    public Account save(Account account) {
        try(Connection connection = DatabaseConnectionManager.connect()){
            createAccountTable(connection);


            String insertSql = """
                    INSERT into accounts(`id`, `name`, `balance`) values(NULL, ?, ?)
                    """;
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);
            insertStatement.setString(1, account.getName());
            insertStatement.setBigDecimal(2, account.getBalance());
            insertStatement.execute();
//            return account;
        }catch(Exception exception){
            System.err.println(exception.getMessage());

        }

        return getSavedAccount();
    }

    private static void createAccountTable(Connection connection) throws SQLException {
        String createAccountSql = """
                      CREATE TABLE IF NOT EXISTS`joshnick_wallet`.`accounts` (
                      `id` INT NOT NULL AUTO_INCREMENT,
                      `name` VARCHAR(255) NULL,
                      `balance` DECIMAL(65) NULL,
                      PRIMARY KEY (`id`),
                      UNIQUE INDEX `accounts_UNIQUE` (`id` ASC) VISIBLE);
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(createAccountSql);
        preparedStatement.execute();

    }

    private Account getSavedAccount(){
        try(Connection connection = DatabaseConnectionManager.connect()){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts ");
            ResultSet resultSet = preparedStatement.executeQuery();

            Account account = null;
            while (resultSet.next()) {
                account  = new Account();
                account.setId(resultSet.getInt(1));
                account.setName(resultSet.getString(2));
                account.setBalance(resultSet.getBigDecimal(3));
            }
            return account;



            }catch (Exception exception){
            System.err.println(exception.getMessage());
            throw new RuntimeException();
        }

    }
}
