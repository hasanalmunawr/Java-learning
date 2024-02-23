package hasan.devp.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyControler {
    private static final Logger log = LoggerFactory.getLogger(MyControler.class);
    private MyService myService;

    public MyControler(MyService myService) {
        this.myService = myService;
    }

    public void save() {
        log.info("Controler Save");
        this.myService.save();
    }
}
