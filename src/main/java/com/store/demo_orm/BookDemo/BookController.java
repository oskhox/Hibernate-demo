package com.store.demo_orm.BookDemo;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //ger JSON
@RequestMapping("/api") //bas-api för att lösa mappningskonflikter
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo, BookRepository bookRepository) {
        this.repo = repo;
    }

    //hitta alla böcker
    @GetMapping("books")
    public List<Book> books() {
        return repo.findAll();
    }

    //hitta via id
    @GetMapping("books/{id}")
    public Book findById(@PathVariable Long id) { //pga inparameter
        return repo.findById(id).get();
    }

    //A) lägg till bok via POST för att skapa nya resurser och terminalen - very RESTful
    //terminalkommando eller postman inkl. NULL
    @PostMapping("books/add")
    public List<Book> addBooks(@Valid  @RequestBody Book b) {//eftersom skickar in ett helt objekt
        repo.save(b);
        return repo.findAll();
    }

    //B) lägg till bok med GET och parametrar - not very RESTful
    //For demo only
    //localhost:8080/api/books/addByGET?title=ccc&author=ddd
    @GetMapping("books/addByGET")
    public List<Book> addByGET(@Valid @RequestParam String title, @RequestParam String author) { //pga inparameter
        repo.save(new Book(null, title, author)); //passing null as ID as it auto increments
        return repo.findAll();
    }

    //ta bort via id
    @DeleteMapping("books/{id}/delete")
    public List<Book> deleteById(@PathVariable Long id) { //pga inparameter
        repo.deleteById(id);
        return repo.findAll();
    }

    //uppdatera eller lägg till ny via id
    //anropa från terminalen eller postman inkl. NULL
    @PutMapping("books/update")
    public List<Book> updateBooks(@RequestBody Book b) {
        if (b.getId() != null && repo.existsById(b.getId())) {
            Book existingBook = repo.findById(b.getId()).get();
            existingBook.setTitle(b.getTitle());
            existingBook.setAuthor(b.getAuthor());
            repo.save(existingBook);
        } else {
            Book newBook = new Book(null, b.getTitle(), b.getAuthor());
            repo.save(newBook);
        }
        return repo.findAll();
    }
}