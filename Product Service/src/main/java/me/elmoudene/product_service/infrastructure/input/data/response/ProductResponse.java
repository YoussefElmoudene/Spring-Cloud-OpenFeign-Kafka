package me.elmoudene.product_service.infrastructure.input.data.response;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private double price;
    private String description;
    private String consumerId;
}
