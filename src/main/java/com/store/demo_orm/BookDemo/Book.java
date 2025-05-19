package com.store.demo_orm.BookDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //att vi skapar upp en tabell med klassens namn som default
@Data //lombok som autogenererar osynliga getters och setters, default-konstruktor
@AllArgsConstructor(access = AccessLevel.PROTECTED) //vill ha hela konstruktorn, längre fram
@NoArgsConstructor(access = AccessLevel.PROTECTED) //vill ha tomma konstruktorn, längre fram
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Title is mandatory")
    @Size(min = 3, message = "At least three characters for title")
    private String title;

    @NotEmpty(message = "Author is mandatory")
    @Size(min = 3, message = "At least three characters for author")
    @Pattern(regexp = "[A-Za-zÀ-ÖØ-öø-ÿ\\s.\\-']*$", message = "Only letters, spaces, and basic punctuation for author")
    private String author;
}