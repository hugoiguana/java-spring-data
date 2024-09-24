package com.hugo.java.spring.data.repository.projections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class ProductByCategoryIdViewProjection2 {

    UUID id;

    String name;

    String description;

    UUID categoryId;

    String categoryName;

}
