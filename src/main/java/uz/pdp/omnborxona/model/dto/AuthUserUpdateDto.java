package uz.pdp.omnborxona.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserUpdateDto {
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean superAdmin;
    private String phone;
    private String imageUrl;
    private String warehouseId;
}
