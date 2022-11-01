package com.ob.restapp.books.services;

import com.ob.restapp.books.models.Book;

public class BookPriceCalculator {
  
  
  public static final int PRICE_INCREMENT = 5;
  public static final int MIN_NUM_PAGES = 300;
  public static final int SHIPPING_COST = 100;
  
  
  public double calculatePrice(Book book) {
    
    if (book == null) {
      throw new NullPointerException("El libro no puede ser nulo");
    }
    
    double price = book.getPrice();
    
    if (book.getNumPages() > MIN_NUM_PAGES) {
      price += PRICE_INCREMENT;
    }
    
    
    price += SHIPPING_COST;
    
    return price;
    
  }
}
