package com.hugo.java.spring.data.service;

import com.hugo.java.spring.data.repository.ProductRepository;
import com.hugo.java.spring.data.repository.projections.ProductByCategoryIdViewProjection;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public List<ProductByCategoryIdViewProjection> getViewAllProductsByCategoryId(UUID categoryId) {
        return productRepository.getProductByCategoryIdView(categoryId, "c.name", "ASC");
    }
}
