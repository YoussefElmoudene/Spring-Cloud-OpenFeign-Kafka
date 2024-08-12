package me.elmoudene.product_service.infrastructure.input.data.request;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    private String name;
    private double price;
    private String description;
    private String consumerId;
}
