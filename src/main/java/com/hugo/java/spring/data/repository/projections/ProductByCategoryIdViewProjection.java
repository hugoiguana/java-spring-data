package com.hugo.java.spring.data.repository.projections;

import java.util.UUID;

public interface ProductByCategoryIdViewProjection {

    UUID getId();

    String getName();

    String getDescription();

    UUID getCategoryId();

    String getCategoryName();

}
