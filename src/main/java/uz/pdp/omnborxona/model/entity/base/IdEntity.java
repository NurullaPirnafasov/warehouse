package uz.pdp.omnborxona.model.entity.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class IdEntity {
    @Id
    private String id;
    public IdEntity() {
        this.id = UUID.randomUUID().toString();
    }

}
