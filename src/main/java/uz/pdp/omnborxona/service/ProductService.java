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
import java.util.Optional;
import java.util.stream.Collectors;
@ApplicationScoped
public class ProductService extends AbstractService<ProductMapper, ProductRepository, ProductValidator>
        implements CrudService<ProductDto, ProductCreateDto, ProductUpdateDto, String> {

    private final WarehouseRepository warehouseRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductMapper mapper,
                          ProductRepository repository,
                          ProductValidator validator,
                          WarehouseRepository warehouseRepository,
                          CategoryRepository categoryRepository) {
        super(mapper, repository, validator);
        this.warehouseRepository = warehouseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void create(ProductCreateDto dto) {

        Warehouse warehouse = warehouseRepository.findById(dto.getWarehouseId())
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        product.setQuantity(dto.getQuantity());
        product.setWarehouse(warehouse);
        product.setCategory(category);

        repository.save(product);
    }

    @Override
    public ProductDto update(ProductUpdateDto dto, String id) {
        validator.existsAndGet(id);

        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        product.setQuantity(dto.getQuantity());

        repository.save(product);
        return mapper.toDto(product);
    }

    @Override
    public ProductDto get(String id) {
        Optional<Product> productOpt = repository.findById(id);
        return productOpt.map(mapper::toDto).orElse(null);
    }

    @Override
    public List<ProductDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        Product product=validator.existsAndGet(id);
        repository.delete(product);
    }
}
