package com.ob.restapp.books.controllers;

import com.ob.restapp.books.models.Book;
import com.ob.restapp.books.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
  
  private final Logger log = LoggerFactory.getLogger(BookController.class);
  
  private final BookRepository repo;
  
  public BookController(BookRepository repo) {
    this.repo = repo;
  }
  
  
  @GetMapping("/api/books")
  public List<Book> getAllBooks() {
    return repo.findAll();
  }
  
  @GetMapping("/api/books/{id}")
  public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id) {
    
    Optional<Book> response = repo.findById(id);
    
    if (response.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    
    return ResponseEntity.ok(response);
  }
  
  @PostMapping("/api/books")
  public ResponseEntity<Book> createBook(@RequestBody Book book) {
    repo.save(book);
    return ResponseEntity.ok(book);
  }
  
  @PutMapping("/api/books")
  public ResponseEntity<Book> updateBook(@RequestBody Book book) {
    if (book.getId() == null) {
      log.warn("El libro no existe");
      return ResponseEntity.badRequest().build();
    }
    
    if (!repo.existsById(book.getId())) {
      log.warn("estas intentando actualizar un libro que no existe");
      return ResponseEntity.notFound().build();
    }
    
    return ResponseEntity.ok(repo.save(book));
  }
  
  @DeleteMapping("/api/books/{id}")
  public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
  
    if (!repo.existsById(id)) {
      log.warn("El libro no existe");
      return ResponseEntity.notFound().build();
    }
    
    repo.deleteById(id);
    return ResponseEntity.noContent().build();
  }
  
  @ApiIgnore
  @DeleteMapping("/api/books")
  ResponseEntity<Book> deleteAll() {
    if (repo.count() < 1){
      log.warn("No hay elementos suficientes en la DB");
      return ResponseEntity.noContent().build();
    }
    
    repo.deleteAll();
    log.info("Todos los elementos fueron eliminados");
    return ResponseEntity.ok().build();
  }
}
