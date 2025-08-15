package uz.pdp.omnborxona.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import uz.pdp.omnborxona.model.dto.ProductCreateDto;
import uz.pdp.omnborxona.model.dto.ProductDto;
import uz.pdp.omnborxona.model.dto.ProductUpdateDto;
import uz.pdp.omnborxona.model.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductMapper {

    public List<ProductDto> toDto (List<Product> products){
        return products.stream().map(this::toDto).collect(Collectors.toList());

    }
    public ProductDto toDto (Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .quantity(product.getQuantity())
                .warehouseId(product.getWarehouse().getId())
                .categoryId(product.getCategory().getId()).build();
    }
    public void fromDto(ProductUpdateDto dto, Product product){
        if(dto.getName() != null) product.setName(dto.getName());
        if(dto.getDescription() != null) product.setDescription(dto.getDescription());
        if(dto.getPrice() != null) product.setPrice(dto.getPrice());
        if(dto.getImage() != null) product.setImage(dto.getImage());
        if(dto.getQuantity() != null) product.setQuantity(dto.getQuantity());
//        if(dto.getWarehouseId() != null) product.setWarehouse(dto.getWarehouseId());


    }
    public Product fromDto(ProductCreateDto dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        product.setQuantity(dto.getQuantity());
        return product;
    }




}
