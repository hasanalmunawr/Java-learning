package hasan.database;

import hasan.database.entity.Comment;
import hasan.database.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CommentRepository {

    private CommentRepositoryImpl commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() { //SUCCES
        Comment comment = new Comment("email", "hai emil");
        commentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId());
        System.out.println(comment.getId());
    }

    @Test
    void testFindById() {
        Comment comment = commentRepository.findById(713);
        Assertions.assertNotNull(comment);
        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment());

    }

    @Test
    void testFindAll() { //SUCCES
        List<Comment> commentList = commentRepository.findAll();
        Assertions.assertNotNull(commentList);
        System.out.println(commentList.size());
    }

    @Test
    void testFindByEmail() { //SUCCES
        List<Comment> commentList = commentRepository.findAllByEmail("email");
        Assertions.assertNotNull(commentList);
        System.out.println(commentList.size());
    }
}
