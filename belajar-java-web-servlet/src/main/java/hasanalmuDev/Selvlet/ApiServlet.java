package hasanalmuDev.Selvlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.JsonUtil;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/api/say-hello")
public class ApiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SayyHelloRequest sayyHelloRequest = JsonUtil.getObjectMapper().readValue(req.getReader(), SayyHelloRequest.class);
        String sayHello = "hello "+ sayyHelloRequest.getFirstName()+" "+sayyHelloRequest.getLastName();

        Map<String, String> response = Map.of(
                "data", sayHello
        );

        String jsonResponse = JsonUtil.getObjectMapper().writeValueAsString(response);
        resp.setHeader("Content-Type", "application/json");
        resp.getWriter().println(jsonResponse);

    }
}
