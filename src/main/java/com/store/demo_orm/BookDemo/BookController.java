package com.store.demo_orm.BookDemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //ger JSON
@RequestMapping("/api") //bas-api för att lösa mappningskonflikter
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    //hitta alla böcker
    @RequestMapping("books")
    public List<Book> books() {
        return repo.findAll();
    }

    //hitta via id
    @RequestMapping("books/{id}")
    public Book findById(@PathVariable Long id) { //pga inparameter
        return repo.findById(id).get();
    }

    //lägg till
    @PostMapping("books/add")
    public List<Book> addBooks(@RequestBody Book b) {
        repo.save(b);
        return repo.findAll();
    }

    //ta bort via id
    @RequestMapping("books/{id}/delete")
    public List<Book> deleteById(@PathVariable Long id) { //pga inparameter
        repo.deleteById(id);
        return repo.findAll();
    }
}