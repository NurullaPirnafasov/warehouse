package uz.pdp.omnborxona.mapper;

import uz.pdp.omnborxona.model.dto.AuthUserCreateDto;
import uz.pdp.omnborxona.model.dto.AuthUserDto;
import uz.pdp.omnborxona.model.dto.AuthUserUpdateDto;
import uz.pdp.omnborxona.model.entity.AuthUser;
import uz.pdp.omnborxona.model.entity.Warehouse;

import java.util.List;
import java.util.stream.Collectors;

public class AuthUserMapper {
    public AuthUserDto toDto(AuthUser entity) {
        if (entity == null) {
            return null;
        }
        AuthUserDto dto=new AuthUserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setSuperAdmin(entity.isSuperAdmin());
        dto.setPhone(entity.getPhone());
        dto.setImageUrl(entity.getImageUrl());
        dto.setWarehouseId(entity.getWarehouse()!=null?entity.getWarehouse().getId():null);
        return dto;
    }

    public AuthUser fromCreateDto(AuthUserCreateDto dto) {
        if (dto == null) return null;

        AuthUser entity = new AuthUser();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSuperAdmin(dto.isSuperAdmin());
        entity.setPhone(dto.getPhone());
        entity.setImageUrl(dto.getImageUrl());

        if (dto.getWarehouseId() != null) {
            Warehouse warehouse = new Warehouse();
            warehouse.setId(dto.getWarehouseId());
            entity.setWarehouse(warehouse);
        }

        return entity;
    }

    public void updateEntityFromDto(AuthUserUpdateDto dto, AuthUser entity) {
        if (dto == null || entity == null) return;

        entity.setUsername(dto.getUsername());
        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            entity.setPassword(dto.getPassword());
        }
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSuperAdmin(dto.isSuperAdmin());
        entity.setPhone(dto.getPhone());
        entity.setImageUrl(dto.getImageUrl());

        if (dto.getWarehouseId() != null) {
            Warehouse warehouse = new Warehouse();
            warehouse.setId(dto.getWarehouseId());
            entity.setWarehouse(warehouse);
        }
    }

    public AuthUser fromDto(AuthUserDto dto) {
        if (dto == null) return null;

        AuthUser entity = new AuthUser();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSuperAdmin(dto.isSuperAdmin());
        entity.setPhone(dto.getPhone());
        entity.setImageUrl(dto.getImageUrl());

        if (dto.getWarehouseId() != null) {
            Warehouse warehouse = new Warehouse();
            warehouse.setId(dto.getWarehouseId());
            entity.setWarehouse(warehouse);
        }
        return entity;
    }

    public List<AuthUserDto> toDto(List<AuthUser> authUsers) {
        return authUsers.stream().map(this::toDto).collect(Collectors.toList());
    }
}
