package com.hugo.java.spring.data.service;

import com.hugo.java.spring.data.repository.ProductRepository;
import com.hugo.java.spring.data.repository.projections.ProductByCategoryIdViewProjection;
import com.hugo.java.spring.data.repository.projections.ProductByCategoryIdViewProjection2;
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
    public List<ProductByCategoryIdViewProjection> getBookUsingQueryProjectionAndFunctionAsViewOnPostgres(UUID categoryId) {
        return productRepository.getBookUsingQueryProjectionAndFunctionAsViewOnPostgres(categoryId, "c.name", "ASC");
    }

    @Override
    public List<ProductByCategoryIdViewProjection2> getProductByCategoryIdViewUsingEntityManagerQuery(UUID categoryId) {
        return productRepository.getProductByCategoryIdViewUsingEntityManagerQuery(categoryId, "c.name", "ASC");
    }


}
