package com.store.demo_orm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //lombok som autogenererar osynliga getters och setters
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String author;
}