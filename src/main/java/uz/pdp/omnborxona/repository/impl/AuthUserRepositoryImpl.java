package uz.pdp.omnborxona.repository.impl;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import uz.pdp.omnborxona.model.entity.AuthUser;
import uz.pdp.omnborxona.repository.AuthUserRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class AuthUserRepositoryImpl implements AuthUserRepository {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Override
    public Optional<AuthUser> findById(String id) {
        return entityManager.createQuery(
                        "select a from AuthUser a where a.id = :id", AuthUser.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst();
    }

    @Override
    public List<AuthUser> findAll() {
        return entityManager.createQuery("select a from AuthUser a", AuthUser.class)
                .getResultList();
    }

    @Override
    public AuthUser save(AuthUser entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        }
        return entityManager.merge(entity);
    }

    @Override
    public void delete(AuthUser entity) {
        if (entity != null) {
            entity.setDeleted(true);
            if (!entityManager.contains(entity)) {
                entityManager.merge(entity);
            }
        }
    }
}
