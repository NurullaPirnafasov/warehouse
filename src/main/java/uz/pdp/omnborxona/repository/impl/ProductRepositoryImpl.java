package uz.pdp.omnborxona.repository.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import uz.pdp.omnborxona.model.entity.Product;
import uz.pdp.omnborxona.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped // bu klassdan bitta ob'yekt yaratadi va uni "application scope"da saqlaydi.
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext // Jpa bilan ishlash uchun ishlatiladi Em chaqirish uchun
    private EntityManager em;


    @Override
    public Optional<Product> findById(String id) {
       return Optional.ofNullable(em.find(Product.class,id));
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p WHERE p.deleted = false",Product.class).getResultList(); // Faqat o'chirilmaganlarni olish
    }

    @Override
    public Product save(Product entity) {
        if(entity.getId() == null){
            em.persist(entity); // yaratadi;
        }
        else {
            entity = em.merge(entity); // bor bosa yangilidi
        }
        return entity;
    }

    @Override
    public void delete(Product entity) {
        entity.setDeleted(true);
        em.merge(entity);

    }
}
