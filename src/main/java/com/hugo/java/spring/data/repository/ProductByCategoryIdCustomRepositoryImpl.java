package com.hugo.java.spring.data.repository;

import com.hugo.java.spring.data.repository.projections.ProductByCategoryIdViewProjection2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ProductByCategoryIdCustomRepositoryImpl implements ProductByCategoryIdCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductByCategoryIdViewProjection2> getProductByCategoryIdViewUsingEntityManagerQuery(UUID categoryId, String orderColumnName, String orderColumnType) {

        var queryString = """
                    SELECT p.id, p.name, p.description, c.id AS category_id, c.name AS category_name
                     FROM test.product p
                     JOIN test.category c ON c.id = p.id_category
                     WHERE 1 = 1
                """;

        if (Objects.nonNull(categoryId)) {
            queryString = queryString.concat(" AND c.id = :categoryId");
        }

         var query = entityManager.createNativeQuery(queryString, ProductByCategoryIdViewProjection2.class);

        if(Objects.nonNull(categoryId)) {
            query.setParameter("categoryId", categoryId);
        }

        return query.getResultList();
    }
}
