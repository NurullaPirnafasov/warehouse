package uz.pdp.omnborxona.repository.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import uz.pdp.omnborxona.model.entity.Category;
import uz.pdp.omnborxona.repository.CategoryRepository;
import uz.pdp.omnborxona.util.JPAUtil;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public Optional<Category> findById(String id) {
        try  {
            EntityManager em = JPAUtil.getEntityManager();
            return em.createQuery("select c from Category c where c.id = :id", Category.class)
                    .setParameter("id", id)
                    .getResultStream()
                    .findFirst();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> findAll() {
        try  {
            EntityManager em = JPAUtil.getEntityManager();
            return em.createQuery("select c from Category c", Category.class)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category save(Category entity) {
        try  {
            EntityManager em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            if (entity.getId() == null) {
                em.persist(entity);
            } else {
                entity = em.merge(entity);
            }
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Category entity) {
        try  {
            EntityManager em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            if (!em.contains(entity)) {
                entity = em.merge(entity);
            }
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
