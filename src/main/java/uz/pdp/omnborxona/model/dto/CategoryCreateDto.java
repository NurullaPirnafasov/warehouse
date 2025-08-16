package uz.pdp.omnborxona.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryCreateDto {
    private String name;
    private String code;
}
