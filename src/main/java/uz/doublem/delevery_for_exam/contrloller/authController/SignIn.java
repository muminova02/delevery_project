package uz.doublem.delevery_for_exam.contrloller.authController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.doublem.delevery_for_exam.service.AuthService;

import java.io.IOException;

@WebServlet("/sign-in")
public class SignIn extends HttpServlet {
    AuthService authService = AuthService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dbAddress = getServletConfig().getInitParameter("db_address");
        req.setAttribute("sign", false);
        req.getRequestDispatcher("/views/usersPage/public/index.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        authService.signIn(req, resp);
            resp.sendRedirect("/home");


    }
}
