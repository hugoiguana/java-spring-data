package com.hugo.java.spring.data.repository;

import com.hugo.java.spring.data.repository.entity.ProductEntity;
import com.hugo.java.spring.data.repository.projections.ProductByCategoryIdViewProjection;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    Optional<ProductEntity> findById(UUID id);

    List<ProductEntity> findAllByCategoryId(UUID categoryId);


    @Query(value = "SELECT * From test.func_products_view(:categoryId, :orderColumnName, :orderColumnType)"
            , nativeQuery = true)
    List<ProductByCategoryIdViewProjection> getProductByCategoryIdView(UUID categoryId, String orderColumnName, String orderColumnType);

}
