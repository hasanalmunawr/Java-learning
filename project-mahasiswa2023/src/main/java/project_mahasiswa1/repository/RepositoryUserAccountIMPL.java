package project_mahasiswa1.repository;

import com.zaxxer.hikari.HikariDataSource;
import project_mahasiswa1.Util.ConnectionUtil;
import project_mahasiswa1.entity.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class  RepositoryUserAccountIMPL implements RepositoryUserAccount{

    private UserAccount account;
    private HikariDataSource dataSource;

    public RepositoryUserAccountIMPL(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean login(UserAccount userAccountLogin) {
        String sql = " SELECT  * FROM user_account WHERE email = ? AND  password = ? ";
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, userAccountLogin.getEmail());
                preparedStatement.setString(2, userAccountLogin.getPassword());
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    if(resultSet.next()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void register(UserAccount userAccountRegis) {
        String sql = " INSERT INTO user_account(email, password) VALUES(?, ?)";
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, userAccountRegis.getEmail());
                preparedStatement.setString(2, userAccountRegis.getPassword());
                preparedStatement.executeUpdate();
            }
            System.out.println("Succes register");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
