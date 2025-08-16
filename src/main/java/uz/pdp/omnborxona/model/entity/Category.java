package uz.pdp.omnborxona.model.entity;

import jakarta.persistence.Entity;
import lombok.*;
import uz.pdp.omnborxona.model.entity.base.IdEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends IdEntity {
    private String name;
    private String code;
}
