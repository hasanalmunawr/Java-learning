package hasanalmuDev.Selvlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;

@WebServlet(urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("/form"); // memnidahkan ke form
        resp.sendRedirect("/latihan-form"); // memnidahkan ke form
    }
}
