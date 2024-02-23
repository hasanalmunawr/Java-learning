package hasan.devp.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import java.util.UUID;

public class MyTest {

    @Test
    void testRequest() {
        String requstId = UUID.randomUUID().toString();
        MyControler myControler = new MyControler(new MyService(new MyRepository()));

//        myControler.save(requstId);
    }

    @Test
    void testMCD() {
        String requstId = UUID.randomUUID().toString();
        MyControler myControler = new MyControler(new MyService(new MyRepository()));

        MDC.put("requestId", requstId);
       new Thread(() -> {
           myControler.save();
       });
       MDC.remove("requestId");
    }

    @Test
    void testMultiThread() throws InterruptedException {
        MyControler myControler = new MyControler(new MyService(new MyRepository()));

        for(int i = 0; i < 10; i++) {
            String requestId = UUID.randomUUID().toString();
            new Thread(() -> {
                MDC.put("requestId", requestId);
                myControler.save();
                MDC.remove("requestId");
            }).start();
        }
        Thread.sleep(1000);
    }
}
