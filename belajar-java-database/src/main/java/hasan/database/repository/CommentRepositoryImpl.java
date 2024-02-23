package hasan.database.repository;

import hasan.database.ConnectionUtil;
import hasan.database.entity.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{

    private Comment comment;
    @Override
    public void insert(Comment comment) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection();) {
            String sql = """
                    INSERT INTO comments(email, comment) VALUES (?, ?)
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, comment.getEmail());
            preparedStatement.setString(2, comment.getComment());
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if(resultSet.next()) {
                    comment.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Comment findById(Integer id) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = " SELECT * FROM comments WHERE id = ? ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    if(resultSet.next()) {
                        return  new Comment(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment")
                        );
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Comment> findAll() {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = """
                    SELECT * FROM comments
                    """;
            try (Statement statement = connection.createStatement();) {
                try(ResultSet resultSet = statement.executeQuery(sql)){
                    List<Comment> commentList = new ArrayList<>();
                    while (resultSet.next()) {
                        commentList.add(new Comment(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment")
                        ));
                    }
                    return  commentList;
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Comment> findAllByEmail(String email) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = """
                    SELECT * FROM comments WHERE email = ?
                    """;
            try (PreparedStatement statement = connection.prepareStatement(sql);) {
                statement.setString(1, email);
                try(ResultSet resultSet = statement.executeQuery()) {
                    List<Comment> commentList = new ArrayList<>();
                    while (resultSet.next()) {
                        commentList.add(new Comment(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment")
                        ));
                    }
                    return  commentList;
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
