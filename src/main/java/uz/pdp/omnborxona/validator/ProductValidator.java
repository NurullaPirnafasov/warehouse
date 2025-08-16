package uz.pdp.omnborxona.validator;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uz.pdp.omnborxona.model.dto.ProductCreateDto;
import uz.pdp.omnborxona.model.entity.Product;
import uz.pdp.omnborxona.repository.ProductRepository;

@ApplicationScoped
public class ProductValidator {

    @Inject
    private ProductRepository repository;

    public Product existsAndGet(String id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Product with id " + id + "not found")
        );
    }

}
