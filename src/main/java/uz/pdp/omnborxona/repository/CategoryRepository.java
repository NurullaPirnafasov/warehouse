package uz.pdp.omnborxona.repository;


import jakarta.enterprise.context.ApplicationScoped;
import uz.pdp.omnborxona.model.entity.Category;
import uz.pdp.omnborxona.repository.base.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends CrudRepository<Category, String> {
    @Override
    Optional<Category> findById(String id);

    @Override
    List<Category> findAll();

    @Override
    Category save(Category entity);

    @Override
    void delete(Category entity);
}
