package com.hugo.java.spring.data.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class ProductByCategoryIdViewDto {

    UUID Id;

    String name;

    String description;

    UUID categoryId;

    String categoryName;

}
