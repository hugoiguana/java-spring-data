package com.hugo.java.spring.data.controller;

import com.hugo.java.spring.data.controller.dto.ProductByCategoryIdViewDto;
import com.hugo.java.spring.data.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@RestController
@RequestMapping("products/v1")
public class ProductController {

    ProductService productService;

    @GetMapping(value = "/category/{categoryId}/v1", produces = "application/json")
    public ResponseEntity<List<ProductByCategoryIdViewDto>> getBookUsingQueryProjectionAndFunctionAsViewOnPostgres(@PathVariable UUID categoryId) {

        var productByCategoryIdViewDto = productService.getBookUsingQueryProjectionAndFunctionAsViewOnPostgres(categoryId)
                .stream()
                .map(p -> ProductByCategoryIdViewDto.builder()
                            .Id(p.getId())
                            .name(p.getName())
                            .description(p.getDescription())
                            .categoryId(p.getCategoryId())
                            .categoryName(p.getCategoryName())
                        .build()
                ).toList();

        return ResponseEntity.ok(productByCategoryIdViewDto);
    }

    @GetMapping(value = "/category/{categoryId}/v2", produces = "application/json")
    public ResponseEntity<List<ProductByCategoryIdViewDto>> getBook(@PathVariable UUID categoryId) {

        var productByCategoryIdViewDto = productService.getProductByCategoryIdViewUsingEntityManagerQuery(categoryId)
                .stream()
                .map(p -> ProductByCategoryIdViewDto.builder()
                        .Id(p.getId())
                        .name(p.getName())
                        .description(p.getDescription())
                        .categoryId(p.getCategoryId())
                        .categoryName(p.getCategoryName())
                        .build()
                ).toList();

        return ResponseEntity.ok(productByCategoryIdViewDto);
    }

}
