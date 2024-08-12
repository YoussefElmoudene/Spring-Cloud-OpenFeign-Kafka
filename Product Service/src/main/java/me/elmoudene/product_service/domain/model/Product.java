package me.elmoudene.product_service.domain.model;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Long id;
    private String name;
    private double price;
    private String description;
    private String consumerId;
}
