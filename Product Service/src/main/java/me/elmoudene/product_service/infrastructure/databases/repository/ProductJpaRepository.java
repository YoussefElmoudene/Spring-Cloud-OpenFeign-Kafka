package me.elmoudene.product_service.infrastructure.databases.repository;

import me.elmoudene.product_service.infrastructure.databases.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByConsumerId(String consumerId);
}
