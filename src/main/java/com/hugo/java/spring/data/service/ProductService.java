package com.hugo.java.spring.data.service;

import com.hugo.java.spring.data.repository.projections.ProductByCategoryIdViewProjection;
import com.hugo.java.spring.data.repository.projections.ProductByCategoryIdViewProjection2;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductByCategoryIdViewProjection> getBookUsingQueryProjectionAndFunctionAsViewOnPostgres(UUID categoryId);

    List<ProductByCategoryIdViewProjection2> getProductByCategoryIdViewUsingEntityManagerQuery(UUID categoryId);

}
