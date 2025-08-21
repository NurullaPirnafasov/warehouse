package uz.pdp.omnborxona.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uz.pdp.omnborxona.model.dto.ProductCreateDto;
import uz.pdp.omnborxona.model.dto.ProductDto;
import uz.pdp.omnborxona.model.dto.ProductUpdateDto;
import uz.pdp.omnborxona.model.entity.Category;
import uz.pdp.omnborxona.model.entity.Product;
import uz.pdp.omnborxona.model.entity.Warehouse;
import uz.pdp.omnborxona.repository.CategoryRepository;
import uz.pdp.omnborxona.repository.WarehouseRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductMapper {
    @Inject
    WarehouseRepository warehouseRepository;

    @Inject
    CategoryRepository categoryRepository;

    public List<ProductDto> toDto (List<Product> products){
        return products.stream().map(this::toDto).collect(Collectors.toList());

    }
    // botdan 1 ta entityni dtoga aylantiradi;

    public ProductDto toDto (Product product){
        return ProductDto.builder().id(product.getId()) // Builder orqali yangi DTO yaratadi.
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .quantity(product.getQuantity())
                .warehouseId(product.getWarehouse().getId())
                .categoryId(product.getCategory().getId()).build();
    }
    public void fromDto(ProductUpdateDto dto, Product product){ // // Update DTO’dan entity’ni yangilaydi.
        if(dto.getName() != null) product.setName(dto.getName());
        if(dto.getDescription() != null) product.setDescription(dto.getDescription());
        if(dto.getPrice() != null) product.setPrice(dto.getPrice());
        if(dto.getImage() != null) product.setImage(dto.getImage());
        if(dto.getQuantity() != null) product.setQuantity(dto.getQuantity());
        if(dto.getWarehouseId() != null){
            Warehouse warehouse = warehouseRepository.findById(dto.getWarehouseId()).
                    orElseThrow(() -> new RuntimeException("Warehouse with id " + dto.getWarehouseId() + "  not found") );
            product.setWarehouse(warehouse);

            if(dto.getCategoryId() != null){
                Category category = categoryRepository.findById(dto.getCategoryId())
                        .orElseThrow(() -> new RuntimeException("Category with id " + dto.getCategoryId() + "not found"));
                product.setCategory(category);
            }

        }


    }
    public Product fromDto (ProductCreateDto dto){ // creatDto dan yangi entity yaratadi
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        product.setQuantity(dto.getQuantity());
        if(dto.getWarehouseId() != null){
            Warehouse warehouse = warehouseRepository.findById(dto.getWarehouseId()).
                    orElseThrow(()-> new RuntimeException("Warehouse with id " + dto.getWarehouseId() + " not found"));
            product.setWarehouse(warehouse);
        }
        if(dto.getCategoryId() != null){
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category with id " + dto.getCategoryId() + " not found"));
            product.setCategory(category);
        }
        return product;

    }



}
