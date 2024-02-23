package project_mahasiswa1.repository;

import com.zaxxer.hikari.HikariDataSource;
import project_mahasiswa1.Util.ConnectionUtil;
import project_mahasiswa1.entity.UserAccount;
import project_mahasiswa1.entity.UserInformation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryAccountFullIMPL implements RepositoryAccountFull{

    private HikariDataSource dataSource;

    public RepositoryAccountFullIMPL(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<UserInformation> getAll() {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = " SELECT * FROM user_information ";
            try (Statement statement = connection.createStatement()) {
                try(ResultSet resultSet = statement.executeQuery(sql)){
                    List<UserInformation> userList = new ArrayList<>();
                    while (resultSet.next()) {
                        userList.add(new UserInformation(
                                resultSet.getString("nim"),
                                resultSet.getString("nama"),
                                resultSet.getString("program_studi")
                        ));
                    }
                    return  userList;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserInformation getUser(UserAccount userAccount) {
        String sql = " SELECT * FROM user_information  Join user_account On (user_account.id_nim = user_information.nim) where email = ? ";
        try(Connection connection = ConnectionUtil.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userAccount.getEmail());
            UserInformation user = new UserInformation();
            try(ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next()) {
                user.setNim(resultSet.getString("nim"));
                user.setNama(resultSet.getString("nama"));
                user.setProdi(resultSet.getString("program_studi"));
                }
            }
            return  user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
