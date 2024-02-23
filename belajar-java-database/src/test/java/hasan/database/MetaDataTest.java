package hasan.database;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.sql.PreparedStatement;

public class MetaDataTest {

    @Test
    void testMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
       DatabaseMetaData metaData = connection.getMetaData();

        System.out.println(metaData.getDatabaseProductName());
        System.out.println(metaData.getDatabaseProductVersion());

        ResultSet tables = metaData.getTables("belajar_java_database", null, null, null);

        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            System.out.println("Nama table = " + tableName);

        }
        connection.close();
    }

    @Test
    void testParameterMetadata() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = """
                INSERT INTO comments(email, comment) VALUES(?, ?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();

        System.out.println(parameterMetaData.getParameterCount()); //jumlah parameter yang dimasukan
        System.out.println(parameterMetaData.getParameterType(1));

        preparedStatement.close();
        connection.close();
    }

    @Test
    void testResultSetMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
       Statement statement = connection.createStatement();
       String sql = """
               SELECT * FROM times
               """;
       ResultSet resultSet = statement.executeQuery(sql);
       ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

       for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
           System.out.println("Nama : " + resultSetMetaData.getColumnName(i));
           System.out.println("Type : " + resultSetMetaData.getColumnType(i));
           System.out.println("type nama : " + resultSetMetaData.getColumnTypeName(i));

           if(resultSetMetaData.getColumnType(i) == Types.INTEGER) {
               System.out.println("ini int");
           }
       }

//       java.sql.Types. UNTUK MELIHAT TYPE DATA


       resultSet.close();
       statement.close();
       connection.close();
    }
}
