package uz.pdp.omnborxona.repository.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import uz.pdp.omnborxona.model.entity.AuthUser;
import uz.pdp.omnborxona.repository.AuthUserRepository;
import uz.pdp.omnborxona.util.JPAUtil;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuthUserRepositoryImpl implements AuthUserRepository {

    @Override
    public Optional<AuthUser> findById(String id) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return em.createQuery("select a from AuthUser a where a.id = :id", AuthUser.class)
                    .setParameter("id", id)
                    .getResultStream()
                    .findFirst();
        }
    }

    @Override
    public List<AuthUser> findAll() {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return em.createQuery("select a from AuthUser a", AuthUser.class)
                    .getResultList();
        }
    }

    @Override
    public AuthUser save(AuthUser entity) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
            if (entity.getId() == null) {
                em.persist(entity);
            } else {
                entity = em.merge(entity);
            }
            em.getTransaction().commit();
            return entity;
        }
    }

    @Override
    public void delete(AuthUser entity) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
            entity.setDeleted(true);
            if (!em.contains(entity)) {
                entity = em.merge(entity);
            }
            em.remove(entity);
            em.getTransaction().commit();
        }
    }
}
