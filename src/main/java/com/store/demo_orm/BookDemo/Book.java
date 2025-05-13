package com.store.demo_orm.BookDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //att vi skapar upp en tabell med klassens namn som default
@Data //lombok som autogenererar osynliga getters och setters
@AllArgsConstructor(access = AccessLevel.PROTECTED) //vill ha hela konstruktorn, längre fram
@NoArgsConstructor(access = AccessLevel.PROTECTED) //vill ha tomma konstruktorn, längre fram
public class Book {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String author;
}