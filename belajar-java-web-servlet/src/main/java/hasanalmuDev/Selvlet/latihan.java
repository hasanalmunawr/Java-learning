package hasanalmuDev.Selvlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@WebServlet(urlPatterns = "/latihan-form")
@MultipartConfig
public class latihan extends HttpServlet {

    /*entity = firstName, lastName, age, from, picture*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = Path.of(latihan.class.getResource("/html/latihanForm.html").getPath());
        String html = Files.readString(path);
        resp.getWriter().println(html);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String firstname = req.getParameter("firstName");
//        String lastName = req.getParameter("lastname");
//        String age = req.getParameter("age");
//        String from = req.getParameter("from");
//        Part picture = req.getPart("picture");
//
//        Path pictureLocation = Path.of("upload/"+ UUID.randomUUID().toString() + picture.getSubmittedFileName());
//        Files.copy(picture.getInputStream(), pictureLocation);
//
//       String html = """
//               <html>
//               <body>
//               <div style="text-align: center; margin-top: 50px;">
//                   <h2>User Details</h2>
//                   <p>First Name: $firstName</p>
//                   <p>Last Name: $lastName</p>
//                   <p>Age: $age</p>
//                   <p>From: $from</p>
//                   <p>Profile Picture:</p>
//                   <img src="/upload?file=$picture" alt="Picture" style="width: 200px; height: 200px; margin-top: 10px;">
//               </div>
//               </body>
//               </html>
//               """
//               .replace("$firstName", firstname)
//               .replace("$lastName", lastName)
//               .replace("$age", age)
//               .replace("$from", from)
//               .replace("$picture", pictureLocation.toString());
//
//       resp.getWriter().println(html);
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String age = req.getParameter("age");
        String from = req.getParameter("from");
        Part profile = req.getPart("picture");

        Path uploadLocation = Path.of("upload/" + UUID.randomUUID().toString() + profile.getSubmittedFileName());
        Files.copy(profile.getInputStream(), uploadLocation);

        String html = """
                <html>
                <body>
                 <div style="text-align: center; margin-top: 50px;">
                FirstName : $firstName <br>
                LastName : $lastName <br>
                Age : $age <br>
                From : $from <br>
Picture : <img src="/download?file=$picture" alt="Picture" style="width: 200px; height: 200px; margin-top: 10px;">
                 </div>
                </body>
                <html>
                """
                .replace("$firstName", firstName)
                .replace("$lastName", lastName)
                .replace("$age", age)
                .replace("$from", from)
                .replace("$picture", uploadLocation.getFileName().toString());


        resp.getWriter().println(html);
    }
}
