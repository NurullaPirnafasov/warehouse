package uz.pdp.omnborxona.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import uz.pdp.omnborxona.model.entity.base.BaseEntity;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
public class AuthUser extends BaseEntity {
    @Column(unique = true,nullable = false)
    private String username;
    private String password;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private boolean superAdmin;
    private String phone;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
}

