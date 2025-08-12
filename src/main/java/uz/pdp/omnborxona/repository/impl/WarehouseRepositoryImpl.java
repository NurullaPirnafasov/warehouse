package uz.pdp.omnborxona.repository.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import uz.pdp.omnborxona.model.entity.Warehouse;
import uz.pdp.omnborxona.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class WarehouseRepositoryImpl implements WarehouseRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Optional<Warehouse> findById(String id) {
        return Optional.ofNullable(em.find(Warehouse.class,id));

    }

    @Override
    public List<Warehouse> findAll() {
        return em.createQuery("SELECT w FROM Warehouse w WHERE  w.deleted = false ",Warehouse.class).getResultList();
    }

    @Override
    public Warehouse save(Warehouse entity) {
        if(entity.getId() == null){
            em.persist(entity);
        }
        else {
            entity = em.merge(entity);
        }
        return entity;
    }

    @Override
    public void delete(Warehouse entity) {
        entity.setDeleted(true);
        em.merge(entity);
    }
}
