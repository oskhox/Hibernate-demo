package com.store.demo_orm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoOrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOrmApplication.class, args);
    }
/*
    //Själva bean, som använder repository
    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {
            //Skapa böcker
            Book book1 = new Book(null, "Spring in Action", "Craig Walls");
            Book book2 = new Book(null, "Hibernate in Action", "Christian Bauer");

            //Spara enskilt till databasen
            bookRepository.save(book1);
            bookRepository.save(book2);

            //Eller bookRepository.saveAll(List.of(book1, book2));

            //Hämta alla böcker
            System.out.println("Books found in the database:");
            bookRepository.findAll().forEach(System.out::println);
        };
    }

 */
}


