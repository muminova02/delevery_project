package uz.doublem.delevery_for_exam.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import uz.doublem.delevery_for_exam.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HIBERNATE-UNIT");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void add(Product product) {
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(product);
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    public List<Product> getProductByName(String name) {
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

        try {

            entityManager.getTransaction().begin();
            entityManager.merge(product);
        } finally {
            entityManager.getTransaction().commit();
        }
    }


    public List<Product> getAll() {
        List resultList = new ArrayList();
        try {

            entityManager.getTransaction().begin();
            resultList = entityManager.createNativeQuery("select * from product", Product.class).getResultList();
        } finally {
            entityManager.getTransaction().commit();
        }
        return resultList;

    }

    private static ProductRepository instance;

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    public Product get(String id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    public void delete(int id) {
        try {

            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, id);
            entityManager.remove(product);
        } finally {

            entityManager.getTransaction().commit();
        }
    }
}