package uz.pdp.omnborxona.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import uz.pdp.omnborxona.model.dto.CategoryCreatDto;
import uz.pdp.omnborxona.model.dto.CategoryDto;
import uz.pdp.omnborxona.model.dto.CategoryUpdateDto;
import uz.pdp.omnborxona.model.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CategoryMapper {
    public List<CategoryDto> toDto(List<Category> categories){
        return categories.stream().map(this::toDto).collect(Collectors.toList());

    }
    public CategoryDto toDto(Category category){
        return CategoryDto.builder() // builder orqali Dto yaratadi
                .id(category.getId())
                .name(category.getName())
                .code(category.getCode())
                .build(); // dto obyek qaytaradi;
    }

    public void fromDto(CategoryUpdateDto dto, Category category){
        if(dto.getName() != null){
            category.setName(dto.getName());
        }
        if(dto.getCode() != null){
            category.setCode(dto.getCode());
        }

    }
    public Category fromDto(CategoryCreatDto dto){
        Category category = new Category();
        category.setName(dto.getName());
        category.setCode(dto.getCode());
        return category;
    }
}
