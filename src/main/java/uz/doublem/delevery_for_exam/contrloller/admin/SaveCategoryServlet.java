package uz.doublem.delevery_for_exam.contrloller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.doublem.delevery_for_exam.entity.Category;
import uz.doublem.delevery_for_exam.repository.CategoryRepository;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/admin/saveCategory")
public class SaveCategoryServlet  extends HttpServlet {
    private CategoryRepository categoryRepository = CategoryRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");

            if (name != null && !name.trim().isEmpty()) {
                Category category = categoryRepository.get(id);
                category.setName(name);

                categoryRepository.edit(category);

                resp.getWriter().write("success");
            } else {
                resp.getWriter().write("error");
            }
        }else {
            String name = req.getParameter("name");
            if (name != null && !name.trim().isEmpty()) {
                Category category = new Category();
                category.setName(name);
                categoryRepository.add(category);

                resp.getWriter().write("success");
            } else {
                resp.getWriter().write("error");
            }
        }

    }
}
