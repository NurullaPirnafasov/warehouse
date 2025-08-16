package uz.pdp.omnborxona.mapper;

import uz.pdp.omnborxona.model.dto.*;
import uz.pdp.omnborxona.model.entity.Category;

public class CategoryMapper {

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .code(category.getCode())
                .build();
    }

    public static Category fromCreateDto(CategoryCreateDto dto) {
        return Category.builder()
                .name(dto.getName())
                .code(dto.getCode())
                .build();
    }

    public static void fromUpdateDto(Category category, CategoryUpdateDto dto) {
        category.setName(dto.getName());
        category.setCode(dto.getCode());
    }
}
