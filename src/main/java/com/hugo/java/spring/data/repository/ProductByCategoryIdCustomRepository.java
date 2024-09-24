package com.hugo.java.spring.data.repository;

import com.hugo.java.spring.data.repository.projections.ProductByCategoryIdViewProjection2;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductByCategoryIdCustomRepository {

    List<ProductByCategoryIdViewProjection2> getProductByCategoryIdViewUsingEntityManagerQuery(UUID categoryId, String orderColumnName, String orderColumnType);

}
