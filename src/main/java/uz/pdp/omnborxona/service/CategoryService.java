package uz.pdp.omnborxona.service;

import uz.pdp.omnborxona.mapper.CategoryMapper;
import uz.pdp.omnborxona.model.dto.*;
import uz.pdp.omnborxona.model.entity.Category;
import uz.pdp.omnborxona.repository.impl.CategoryRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService {

    private final CategoryRepositoryImpl repository = new CategoryRepositoryImpl();

    public CategoryDto create(CategoryCreateDto dto) {
        Category category = CategoryMapper.fromCreateDto(dto);
        return CategoryMapper.toDto(repository.save(category));
    }

    public CategoryDto get(String id) {
        return repository.findById(id)
                .map(CategoryMapper::toDto)
                .orElse(null);
    }

    public List<CategoryDto> getAll() {
        return repository.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public CategoryDto update(CategoryUpdateDto dto) {
        return repository.findById(dto.getId())
                .map(category -> {
                    CategoryMapper.fromUpdateDto(category, dto);
                    return CategoryMapper.toDto(repository.save(category));
                })
                .orElse(null);
    }

    public void delete(String id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
