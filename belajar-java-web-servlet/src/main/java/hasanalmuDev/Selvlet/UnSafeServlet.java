package hasanalmuDev.Selvlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/unsafe")
public class UnSafeServlet extends  HelloServlet {

//    String respone = " ";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String respone = " ";
        String name = req.getParameter("name");
        Long sleap = Long.parseLong(req.getParameter("sleep"));

        respone = "hello " + name;

        try {
            Thread.sleep(sleap);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        resp.getWriter().println(respone);
    }
}
