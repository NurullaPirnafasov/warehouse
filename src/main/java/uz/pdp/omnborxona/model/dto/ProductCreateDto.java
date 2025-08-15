package uz.pdp.omnborxona.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductCreateDto {
    private String name;
    private String description;
    private Double price;
    private String image;
    private Integer quantity;
    private String warehouseId;
    private String categoryId;

}
