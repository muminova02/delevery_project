package uz.doublem.delevery_for_exam.contrloller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.doublem.delevery_for_exam.repository.ProductRepository;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteProduct extends HttpServlet {
    ProductRepository productRepository = ProductRepository.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        productRepository.delete(id);
        resp.sendRedirect("/product");
    }
}
