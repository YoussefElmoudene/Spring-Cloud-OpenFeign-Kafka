package me.elmoudene.product_service.infrastructure.databases.mapper;

import me.elmoudene.product_service.domain.model.Product;
import me.elmoudene.product_service.infrastructure.databases.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductPersistenceMapper {
    public List<Product> toOperationList(List<ProductEntity> entities) {
        return entities.stream().map(this::toProduct).collect(Collectors.toList());
    }

    public Product toProduct(ProductEntity entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setConsumerId(entity.getConsumerId());
        return product;
    }

    public ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setConsumerId(product.getConsumerId());
        return entity;
    }

}
