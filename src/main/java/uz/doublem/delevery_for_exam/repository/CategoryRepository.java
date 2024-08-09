package uz.doublem.delevery_for_exam.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import uz.doublem.delevery_for_exam.entity.Category;
import uz.doublem.delevery_for_exam.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    EntityManagerFactory entityManagerFactory = Configurations.getEntityManagerFactory();


    public void add(Category category) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(category);
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    public List<Category> getCategoryByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List resultList;
        try {
            entityManager.getTransaction().begin();
            resultList = entityManager.createNativeQuery("select * from category where name = '';", Category.class).getResultList();
        } finally {
            entityManager.getTransaction().commit();
        }
        return resultList;
    }

    public void edit(Category category) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.merge(category);
        } finally {
            entityManager.getTransaction().commit();
        }
    }


    public List<Category> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List resultList = new ArrayList();
        try {

            entityManager.getTransaction().begin();
            resultList = entityManager.createNativeQuery("select * from category", Category.class).getResultList();
        } finally {
            entityManager.getTransaction().commit();
        }
        return resultList;

    }

    private static CategoryRepository instance;

    public static CategoryRepository getInstance() {
        if (instance == null) {
            instance = new CategoryRepository();
        }
        return instance;
    }

    public Category get(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Integer id1 = Integer.valueOf(id);
            entityManager.getTransaction().begin();
            return entityManager.find(Category.class, id1);
        }finally {
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }

    public void delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            Category category = entityManager.find(Category.class, id);
            entityManager.remove(category);
        } finally {

            entityManager.getTransaction().commit();
        }
    }
}
