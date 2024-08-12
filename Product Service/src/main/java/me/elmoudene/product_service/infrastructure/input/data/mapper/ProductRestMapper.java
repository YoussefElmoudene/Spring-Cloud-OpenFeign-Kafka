package me.elmoudene.product_service.infrastructure.input.data.mapper;

import me.elmoudene.product_service.domain.model.Product;
import me.elmoudene.product_service.infrastructure.input.data.request.ProductRequest;
import me.elmoudene.product_service.infrastructure.input.data.response.ProductResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductRestMapper {

    public List<ProductResponse> toResponseList(List<Product> list) {
        List<ProductResponse> ProductResponses = new ArrayList<>();
        for (Product item : list) {
            ProductResponse ProductResponse = toResponse(item);
            ProductResponses.add(ProductResponse);
        }
        return ProductResponses;
    }

    public ProductResponse toResponse(Product item) {
        try {
            ProductResponse ProductResponse = new ProductResponse();
            copyNonNullProperties(item, ProductResponse);
            return ProductResponse;
        } catch (Exception e) {
            return null;
        }
    }

    public Product toItem(ProductRequest requestData) {
        try {
            Product item = new Product();
            copyNonNullProperties(requestData, item);
            return item;
        } catch (Exception e) {
            return null;
        }
    }

    private void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
