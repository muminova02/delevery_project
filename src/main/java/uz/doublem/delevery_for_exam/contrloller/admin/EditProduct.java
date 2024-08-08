package uz.doublem.delevery_for_exam.contrloller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.doublem.delevery_for_exam.entity.Product;
import uz.doublem.delevery_for_exam.repository.ProductRepository;

import java.io.IOException;

@WebServlet("/edit")
public class EditProduct extends HttpServlet {

    ProductRepository repository = ProductRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("product", null);
        if (id != null) {
            Product product = repository.get(id);
            req.setAttribute("product", product);
            req.getRequestDispatcher("/views/edit_product.jsp").forward(req, resp);
        }else {
            resp.getWriter().write("product not found");
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = Double.parseDouble(req.getParameter("price"));
        Product product =

                Product
                        .builder()
                        .id(id)
                        .productName(name)
                        .description(description)
                        .price(price)
                        .build();
        repository.edit(product);
    }
}
