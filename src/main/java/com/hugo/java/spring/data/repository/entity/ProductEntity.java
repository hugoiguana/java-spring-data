package com.hugo.java.spring.data.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(schema = "test", name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductEntity extends AbstractEntity {

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "id_category")
    CategoryEntity category;
    
}
