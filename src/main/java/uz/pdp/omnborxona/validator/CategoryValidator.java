package uz.pdp.omnborxona.validator;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uz.pdp.omnborxona.model.entity.Category;
import uz.pdp.omnborxona.repository.CategoryRepository;

@ApplicationScoped
public class CategoryValidator {
    @Inject
    CategoryRepository categoryRepository;

    public Category existsAndGet(String id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with id " + id + "not found"));
    }
}
