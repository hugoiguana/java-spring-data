package com.hugo.java.spring.data.service;

import com.hugo.java.spring.data.repository.projections.ProductByCategoryIdViewProjection;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductByCategoryIdViewProjection> getViewAllProductsByCategoryId(UUID categoryId);

}
