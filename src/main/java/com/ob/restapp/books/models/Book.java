package com.ob.restapp.books.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@ToString
@Data
@Table(name = "books")
public class Book {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Getter @Setter
  private String author;
  
  @Getter @Setter
  private String title;
  
  @Getter @Setter
  private Integer numPages;
  
  @Getter @Setter
  private Double price;
  
  @Getter @Setter
  private LocalDate releaseDate;
  
  @Getter @Setter
  private Boolean isOnline;
  
  @Builder(builderMethodName = "bookBuilder", builderClassName = "BookBuilder", setterPrefix = "with")
  public Book(String author, String title, Integer numPages, Double price, LocalDate releaseDate, Boolean isOnline) {
    this.author = author;
    this.title = title;
    this.numPages = numPages;
    this.price = price;
    this.releaseDate = releaseDate;
    this.isOnline = isOnline;
  }
  
  public Book() {}
}
