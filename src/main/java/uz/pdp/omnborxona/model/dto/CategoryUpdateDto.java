package uz.pdp.omnborxona.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryUpdateDto {
    private String id;
    private String name;
    private String code;
}
