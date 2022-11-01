package com.ob.restapp.books.controllers;

import com.ob.restapp.books.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {
  
  
  @LocalServerPort
  private int port;
  @Autowired
  private TestRestTemplate restTemplate;
  @Autowired
  private RestTemplateBuilder restTemplateBuilder;
  
  private HttpHeaders headers;
  
  @BeforeEach
  void setUp() {
    restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port + "/");
    restTemplate = new TestRestTemplate(restTemplateBuilder);
  
    headers = new HttpHeaders();
  
    headers.setContentType(MediaType.APPLICATION_JSON);
  }
  
  @DisplayName("Verificar que se haga una peticion GET de forma correcta")
  @Test
  void getAllBooks() {
    ResponseEntity<Book[]> response =
        restTemplate.getForEntity("/api/books", Book[].class);
    
    assertSame(response.getStatusCode(), HttpStatus.OK);
    
    List<Book> ooks = Arrays.asList(Objects.requireNonNull(response.getBody()));
  }
  
  @Test
  void Hello() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/hola", String.class);
    
    assertSame(response.getStatusCode(), HttpStatus.OK);
//    assertEquals("Hola, nos vemos en el fin del mundo", response.getBody());
  }
  
  @DisplayName("Verificar que se obtenga un libro por id")
  @Test
  void getBookById() {
    ResponseEntity<Book> response =
        restTemplate.getForEntity("/api/books/3", Book.class);
    
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }
  
  @DisplayName("Verificar que se cree un libro de forma correcta")
  @Test
  void createBook() {
    
    String bookJson = """
        {
          "author": "Emmanuel Granados",
          "isOnline": true,
          "numPages": 344,
          "price": 3434.34,
          "releaseDate": "2022-10-22",
          "title": "Calculo"
        }
        """;
  
    HttpEntity<String> request = new HttpEntity<>(bookJson, headers);
    ResponseEntity<Book> response = restTemplate.exchange("/api/books", HttpMethod.POST, request, Book.class);
    
    Book result = response.getBody();
  
  
    assert result != null;
    assertEquals(1L, result.getId());
    assertEquals(true, result.getIsOnline());
    
  }
}