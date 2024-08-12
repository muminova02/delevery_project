package uz.doublem.delevery_for_exam.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import uz.doublem.delevery_for_exam.entity.Category;
import uz.doublem.delevery_for_exam.entity.Product;
import uz.doublem.delevery_for_exam.repository.CategoryRepository;
import uz.doublem.delevery_for_exam.repository.ProductRepository;

public class ProductService {
    private ProductRepository productRepository = ProductRepository.getInstance();
    private CategoryRepository categoryRepository = CategoryRepository.getInstance();








    private static ProductService productService;

    public static ProductService getInstance() {
        if (productService == null)
            synchronized (ProductService.class) {
                if (productService == null) {
                    productService = new ProductService();
                }
            }
        return productService;
    }
    @SneakyThrows
    public void editProduct(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String productDescription = req.getParameter("productDescription");
        String productPrice = req.getParameter("productPrice");
        String productCategoryId = req.getParameter("productCategory");
        Category category = categoryRepository.get(productCategoryId);
        if (name != null && !name.trim().isEmpty()) {
            Product product = productRepository.get(id);
            product.setName(name);
            product.setDescription(productDescription);
            product.setPrice(Double.parseDouble(productPrice));
            product.setCategory(category);
            productRepository.edit(product);
            resp.getWriter().write("success");
        } else {
            resp.getWriter().write("error");
        }
    }
    @SneakyThrows
    public void addProduct(HttpServletRequest req, HttpServletResponse resp) {
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
