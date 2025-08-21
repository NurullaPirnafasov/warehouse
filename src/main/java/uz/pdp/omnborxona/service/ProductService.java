package uz.pdp.omnborxona.service;


import jakarta.enterprise.context.ApplicationScoped;
import uz.pdp.omnborxona.mapper.ProductMapper;
import uz.pdp.omnborxona.model.dto.ProductCreateDto;
import uz.pdp.omnborxona.model.dto.ProductDto;
import uz.pdp.omnborxona.model.dto.ProductUpdateDto;
import uz.pdp.omnborxona.model.entity.Category;
import uz.pdp.omnborxona.model.entity.Product;
import uz.pdp.omnborxona.model.entity.Warehouse;
import uz.pdp.omnborxona.repository.CategoryRepository;
import uz.pdp.omnborxona.repository.ProductRepository;
import uz.pdp.omnborxona.repository.WarehouseRepository;
import uz.pdp.omnborxona.service.base.AbstractService;
import uz.pdp.omnborxona.service.base.CrudService;
import uz.pdp.omnborxona.validator.ProductValidator;

import java.util.List;

@ApplicationScoped
public class ProductService extends AbstractService<ProductMapper, ProductRepository, ProductValidator>
       implements CrudService<ProductDto, ProductCreateDto, ProductUpdateDto,String> {
    @Inject
    public ProductService(ProductMapper mapper, ProductRepository repository, ProductValidator validator) {
        super(mapper, repository, validator);
    }

    @Override
    public void create(ProductCreateDto dto) {
        Product product = mapper.fromDto(dto);
        repository.save(product);

    }

    @Override
    public ProductDto update(ProductUpdateDto dto, String id) {
        Product product = validator.existsAndGet(id);
        mapper.fromDto(dto,product);
        Product saved = repository.save(product);
        return mapper.toDto(saved); // botta saqlangan entityni dtoga aylantrib beradi

    }

    @Override
    public ProductDto get(String id) {
        return mapper.toDto(validator.existsAndGet(id));
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = repository.findAll();
        return mapper.toDto(products);
    }

    @Override
    public void delete(String id) {
        Product product = validator.existsAndGet(id);
        repository.delete(product);
    }
}
