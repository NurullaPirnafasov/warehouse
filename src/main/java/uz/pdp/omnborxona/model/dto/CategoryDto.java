package uz.pdp.omnborxona.model.dto;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CategoryDto {
    private String id;
    private String name;
    private String code;
}
