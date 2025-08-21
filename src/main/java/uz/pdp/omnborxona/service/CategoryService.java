package uz.pdp.omnborxona.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uz.pdp.omnborxona.mapper.CategoryMapper;
import uz.pdp.omnborxona.model.dto.CategoryCreatDto;
import uz.pdp.omnborxona.model.dto.CategoryDto;
import uz.pdp.omnborxona.model.dto.CategoryUpdateDto;
import uz.pdp.omnborxona.model.entity.Category;
import uz.pdp.omnborxona.repository.CategoryRepository;
import uz.pdp.omnborxona.service.base.AbstractService;
import uz.pdp.omnborxona.service.base.CrudService;
import uz.pdp.omnborxona.validator.CategoryValidator;

import java.util.List;

@ApplicationScoped

public class CategoryService extends AbstractService<CategoryMapper, CategoryRepository, CategoryValidator>
        implements CrudService<CategoryDto, CategoryCreatDto, CategoryUpdateDto, String> {

    @Inject
    public CategoryService(CategoryMapper mapper, CategoryRepository repository, CategoryValidator validator) {
        super(mapper, repository, validator);
    }

    @Override
    public void create(CategoryCreatDto dto) {
        Category category = mapper.fromDto(dto);
        repository.save(category);

    }

    @Override
    public CategoryDto update(CategoryUpdateDto dto, String id) {
        Category category = validator.existsAndGet(id);
        mapper.fromDto(dto, category);
        Category saved = repository.save(category);
        return mapper.toDto(saved);

    }

    @Override
    public CategoryDto get(String id) {
        return mapper.toDto(validator.existsAndGet(id));
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = repository.findAll();
        return mapper.toDto(categories);
    }

    @Override
    public void delete(String id) {
        Category category = validator.existsAndGet(id);
        repository.delete(category);
    }
}
