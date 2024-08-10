package uz.doublem.delevery_for_exam.contrloller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.doublem.delevery_for_exam.entity.Category;
import uz.doublem.delevery_for_exam.entity.Product;
import uz.doublem.delevery_for_exam.repository.CategoryRepository;
import uz.doublem.delevery_for_exam.repository.ProductRepository;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/admin/saveProduct")
public class SaveProductServlet  extends HttpServlet {
    private ProductRepository productRepository = ProductRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            if (name != null && !name.trim().isEmpty()) {
                Product product = productRepository.get(id);
                product.setName(name);
                productRepository.edit(product);
                resp.getWriter().write("success");
            } else {
                resp.getWriter().write("error");
            }
        }else {
            String name = req.getParameter("name");
            if (name != null && !name.trim().isEmpty()) {
                Product product = new Product();
                product.setName(name);
                productRepository.add(product);
                resp.getWriter().write("success");
            } else {
                resp.getWriter().write("error");
            }
        }

    }
}
