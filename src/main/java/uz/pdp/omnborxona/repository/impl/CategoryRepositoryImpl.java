package uz.pdp.omnborxona.repository.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import uz.pdp.omnborxona.model.entity.Category;
import uz.pdp.omnborxona.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryRepositoryImpl implements CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Category> findById(String id) {
        return Optional.ofNullable(entityManager.find(Category.class,id));
    }

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("from Category",Category.class).getResultList();
    }

    @Override
    public Category save(Category entity) {
        if(entity.getId() == null){
            entityManager.persist(entity);
            return entity;
        }
        else {
            return entityManager.merge(entity);
        }

    }

    @Override
    public void delete(Category entity) {
        entityManager.remove(entity);

    }

}
