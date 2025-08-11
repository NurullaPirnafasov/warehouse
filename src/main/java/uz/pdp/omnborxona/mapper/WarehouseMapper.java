package uz.pdp.omnborxona.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import uz.pdp.omnborxona.model.dto.WarehouseCreateDto;
import uz.pdp.omnborxona.model.dto.WarehouseDto;
import uz.pdp.omnborxona.model.dto.WarehouseUpdateDto;
import uz.pdp.omnborxona.model.entity.Warehouse;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class WarehouseMapper {


    public List<WarehouseDto> toDto(List<Warehouse> warehouses) {
        return warehouses.stream().map(this::toDto).collect(Collectors.toList());
    }

    public WarehouseDto toDto(Warehouse warehouse) {
        return WarehouseDto.builder()
                .id(warehouse.getId())
                .name(warehouse.getName())
                .build();
    }

    public void fromDto(WarehouseUpdateDto dto, Warehouse warehouse) {
        warehouse.setName(dto.getName());
    }

    public Warehouse fromDto(WarehouseCreateDto dto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(dto.getName())    ;
        return warehouse;
    }
}
