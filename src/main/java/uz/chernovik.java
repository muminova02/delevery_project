package uz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//public class chernovik {
//    {
//        EntityManagerFactory entityManagerFactory = Configurations.entityManagerFactory();
//
//
//        public void save(User user) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(user);
//        } finally {
//            entityManager.getTransaction().commit();
//            entityManager.close();
//        }
//    }
//
//        public void editUser(User user) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.merge(user);
//        } finally {
//            entityManager.getTransaction().commit();
//        }
//    }
//
//        public List<User> getUsers() {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        List<User> users = new ArrayList<>();
//        try {
//            em.getTransaction().begin();
//            TypedQuery<User> query = em.createNamedQuery("all.users", User.class);
//            users = query.getResultList();
//        } finally {
//            em.getTransaction().commit();
//        }
//        return users;
//    }
//
//        public Optional<User> getUser(String id) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
//            query.setParameter("id", id);
//            List<User> resultList = query.getResultList();
//            if (!resultList.isEmpty()) {
//                return Optional.of(resultList.get(0));
//            }
//        } finally {
//            em.getTransaction().commit();
//        }
//        return Optional.empty();
//    }
//
//        public void updateUser(String id, User user) {
//
//    }
//
//        public void deleteUser(String id, User user) {
//
//    }
//
//
//
//        public Optional<User> findByJshshir(String jshshir) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        TypedQuery<User> typedQuery = entityManager
//                .createNamedQuery("by.jshshir", User.class)
//                .setParameter("jshshir", jshshir);
//        System.out.println(typedQuery.getFirstResult());
//
//
//        entityManager.getTransaction().commit();
////        if (singleResult != null) {
////            return Optional.of(singleResult);
////        }
//        List<User> resultList = typedQuery.getResultList();
//        if (resultList.isEmpty()) {
//            return Optional.empty();
//        }
//        return Optional.of(resultList.get(0));
//    }
//
//        private static UserRepository userRepository;
//
//        public static UserRepository getInstance() {
//        if (userRepository == null) {
//            userRepository = new UserRepository();
//        }
//        return userRepository;
//    }
//    }
//}
