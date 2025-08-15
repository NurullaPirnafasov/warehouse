package uz.pdp.omnborxona.repository;

import uz.pdp.omnborxona.model.entity.Product;
import uz.pdp.omnborxona.repository.base.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String>  {
    Optional<Product> findById(String id);
    List<Product> findAll();
    Product save (Product entity);
    void delete(Product entity);
}
