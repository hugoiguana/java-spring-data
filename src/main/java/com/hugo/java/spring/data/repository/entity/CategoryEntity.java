package com.hugo.java.spring.data.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(schema = "test", name = "category")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryEntity extends AbstractEntity {

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

}
