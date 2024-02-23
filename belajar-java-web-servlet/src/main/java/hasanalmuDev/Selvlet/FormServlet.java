package hasanalmuDev.Selvlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = Path.of(FormServlet.class.getResource("/html/form.html").getPath());
        String value = Files.readString(path);
        resp.getWriter().println(value);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("firstName") + " " + req.getParameter("lastName");
        String hallo = "hello " + name+ ", selamat datang di web";
        resp.getWriter().println(hallo);
    }
}
