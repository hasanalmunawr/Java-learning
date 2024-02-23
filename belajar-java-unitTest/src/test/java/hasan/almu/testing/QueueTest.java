package hasan.almu.testing;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A queue")
public class QueueTest {

    private Queue<String> queue;

    @Nested
    @DisplayName("when new")
    public  class WhenNew{

        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer, size must be 1")
        void name() {
            queue.offer("hasan");
            Assertions.assertEquals(1,queue.size());
        }
        @Test
        @DisplayName("when offer 2 date, size must be 2")
        void name1() {
            queue.offer("hasan");
            queue.offer("eko");
            Assertions.assertEquals(2,queue.size());
        }
    }
}
