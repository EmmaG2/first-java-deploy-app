package com.ob.restapp;

import com.ob.restapp.books.repository.BookRepository;
import com.ob.restapp.books.models.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.time.LocalDate;

@SpringBootApplication
@EnableWebMvc
public class RestAppApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(RestAppApplication.class, args);
  }
  
}
