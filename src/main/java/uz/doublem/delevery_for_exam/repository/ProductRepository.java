package uz.doublem.delevery_for_exam.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import uz.doublem.delevery_for_exam.entity.Product;
import uz.doublem.delevery_for_exam.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    EntityManagerFactory entityManagerFactory = Configurations.getEntityManagerFactory();


    public void add(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(product);
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    public List<Product> getProductByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List resultList;
        try {
            entityManager.getTransaction().begin();
            resultList = entityManager.createNativeQuery("select * from product where name = '';", Product.class).getResultList();
        } finally {
            entityManager.getTransaction().commit();
        }
        return resultList;
    }

    public void edit(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.merge(product);
        } finally {
            entityManager.getTransaction().commit();
        }
    }


    public <T> List getAll(Class<T> entityType) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List resultList = new ArrayList<T>();
        try {

            entityManager.getTransaction().begin();
            String query = String.format("SELECT * FROM %s", entityType.getSimpleName());
            resultList = entityManager.createNativeQuery(query, entityType).getResultList();
            return resultList;
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
        }

    }



    private static ProductRepository productRepository;

    public static ProductRepository getInstance() {
        if (productRepository == null)
            synchronized (ProductRepository.class) {
                if (productRepository == null) {
                    productRepository = new ProductRepository();
                }
            }
        return productRepository;
    }
    public Product get(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    public void delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, id);
            entityManager.remove(product);
        } finally {

            entityManager.getTransaction().commit();
        }
    }

    public boolean updateProductActive(String productId, boolean b) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, productId);
            product.setActive(b);
            entityManager.merge(product);
            return true;
        }catch (Exception e){
            return false;
        }
        finally {
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}