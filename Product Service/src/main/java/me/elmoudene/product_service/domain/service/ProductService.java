package me.elmoudene.product_service.domain.service;

import me.elmoudene.product_service.application.inpound.ProductUseCase;
import me.elmoudene.product_service.application.outpound.ProductRepository;
import me.elmoudene.product_service.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductUseCase {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.getProduct(productId);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.createProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteProduct(productId);
    }

    @Override
    public List<Product> findByConsumerId(String consumerId) {
        return productRepository.findByConsumerId(consumerId);
    }
}
