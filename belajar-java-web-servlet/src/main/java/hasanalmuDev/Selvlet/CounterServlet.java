package hasanalmuDev.Selvlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@WebServlet(urlPatterns = "/counter")
public class CounterServlet  extends HelloServlet {

    private final AtomicLong atomicLong = new AtomicLong(0L);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long total = atomicLong.incrementAndGet();
        String response = "total " + total;
        resp.getWriter().println(response);
    }


}
