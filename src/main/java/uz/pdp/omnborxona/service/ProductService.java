package uz.pdp.omnborxona.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uz.pdp.omnborxona.mapper.ProductMapper;
import uz.pdp.omnborxona.model.dto.ProductCreateDto;
import uz.pdp.omnborxona.model.dto.ProductDto;
import uz.pdp.omnborxona.model.dto.ProductUpdateDto;
import uz.pdp.omnborxona.repository.CategoryRepository;
import uz.pdp.omnborxona.repository.ProductRepository;
import uz.pdp.omnborxona.repository.WarehouseRepository;
import uz.pdp.omnborxona.service.base.AbstractService;
import uz.pdp.omnborxona.service.base.CrudService;
import uz.pdp.omnborxona.validator.ProductValidator;

@ApplicationScoped
public class ProductService  extends AbstractService<ProductMapper, ProductRepository, ProductValidator>
implements CrudService<ProductDto, ProductCreateDto, ProductUpdateDto, String> {
    @Inject
    private WarehouseRepository warehouseRepository;
    @Inject
    private CategoryRepository categoryRepository;




}
