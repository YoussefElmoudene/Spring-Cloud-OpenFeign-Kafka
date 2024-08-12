package me.elmoudene.product_service.infrastructure.input.rest;

import me.elmoudene.product_service.application.inpound.ProductUseCase;
import me.elmoudene.product_service.domain.model.Product;
import me.elmoudene.product_service.infrastructure.input.data.mapper.ProductRestMapper;
import me.elmoudene.product_service.infrastructure.input.data.request.ProductRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product/")
public class ProductRestController {
    private final ProductUseCase service;
    private final ProductRestMapper mapper;

    public ProductRestController(ProductUseCase service, ProductRestMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("id/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        return service.getProduct(productId);
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductRequest request) {
        Product product = mapper.toItem(request);
        return service.createProduct(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody ProductRequest request) {
        Product product = mapper.toItem(request);
        return service.updateProduct(product);
    }

    @DeleteMapping("id/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        service.deleteProduct(productId);
    }

    @GetMapping("con")
    public List<Product> findByConsumerId(String consumerId) {
        return service.findByConsumerId(consumerId);
    }
}
