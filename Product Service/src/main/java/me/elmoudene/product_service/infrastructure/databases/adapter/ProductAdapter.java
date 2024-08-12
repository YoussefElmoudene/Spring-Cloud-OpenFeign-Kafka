package me.elmoudene.product_service.infrastructure.databases.adapter;

import me.elmoudene.product_service.application.outpound.ProductRepository;
import me.elmoudene.product_service.domain.model.Product;
import me.elmoudene.product_service.infrastructure.databases.entity.ProductEntity;
import me.elmoudene.product_service.infrastructure.databases.mapper.ProductPersistenceMapper;
import me.elmoudene.product_service.infrastructure.databases.repository.ProductJpaRepository;

import java.util.List;

public class ProductAdapter implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;
    private final ProductPersistenceMapper mapper;

    public ProductAdapter(ProductJpaRepository productJpaRepository, ProductPersistenceMapper mapper) {
        this.productJpaRepository = productJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Product getProduct(Long productId) {
        ProductEntity entity = productJpaRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found."));
        return mapper.toProduct(entity);
    }

    @Override
    public Product createProduct(Product product) {
        ProductEntity entity = mapper.toEntity(product);
        entity = productJpaRepository.save(entity);
        return mapper.toProduct(entity);
    }

    @Override
    public Product updateProduct(Product product) {
        ProductEntity entity = productJpaRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("No product found with id: " + product.getId()));
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setConsumerId(product.getConsumerId());
        entity = productJpaRepository.save(entity);
        return mapper.toProduct(entity);
    }

    @Override
    public void deleteProduct(Long productId) {
        productJpaRepository.deleteById(productId);
    }

    @Override
    public List<Product> findByConsumerId(String consumerId) {
        List<ProductEntity> entities = productJpaRepository.findByConsumerId(consumerId);
        return mapper.toOperationList(entities);
    }
}
