package me.elmoudene.product_service.application.inpound;

import me.elmoudene.product_service.domain.model.Product;

import java.util.List;

public interface ProductUseCase {
    Product getProduct(Long productId);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long productId);

    List<Product> findByConsumerId(String consumerId);
}
