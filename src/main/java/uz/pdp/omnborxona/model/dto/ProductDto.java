package uz.pdp.omnborxona.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class ProductDto {
    private String id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private Integer quantity;
    private String warehouseId;
    private String categoryId;

}
