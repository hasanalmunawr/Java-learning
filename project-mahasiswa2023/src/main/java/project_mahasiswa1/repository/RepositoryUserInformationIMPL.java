package project_mahasiswa1.repository;

import com.zaxxer.hikari.HikariDataSource;
import project_mahasiswa1.Util.ConnectionUtil;
import project_mahasiswa1.entity.UserInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositoryUserInformationIMPL implements RepositoryUserInformation{

    private UserInformation userInformation;
    private HikariDataSource dataSource;

    public RepositoryUserInformationIMPL(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addUser(UserInformation userInformation) {
        String sql = "INSERT INTO user_information(nim, nama, program_studi) VALUES(?, ?, ?)";
        try (Connection connection = ConnectionUtil.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, userInformation.getNim());
                statement.setString(2, userInformation.getNama());
                statement.setString(3, userInformation.getProdi());
                statement.executeUpdate();
            System.out.println("berhasil membuat user");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editUser() {

    }
}
