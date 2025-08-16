package uz.pdp.omnborxona.repository.base;

import uz.pdp.omnborxona.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<E, K> {

    Optional<E> findById(K id);

    List<E> findAll();

    E save(E entity);

    void delete(E entity);
}

