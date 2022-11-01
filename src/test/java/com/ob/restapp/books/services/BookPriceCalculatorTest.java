package com.ob.restapp.books.services;

import com.ob.restapp.books.models.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {
  
  private static final Book libro = Book.bookBuilder()
      .withPrice(50.5)
      .withTitle("Emmanuel the lord")
      .withAuthor("Emmanuel Granados")
      .withIsOnline(false)
      .withNumPages(1000)
      .withReleaseDate(LocalDate.now())
      .build();
  
  @Test
  void calculatePrice() {
    BookPriceCalculator calculator = new BookPriceCalculator();
    
    assertTrue(calculator.calculatePrice(libro) > 50.0);
  }
}