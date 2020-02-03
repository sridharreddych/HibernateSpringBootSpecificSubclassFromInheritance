package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private BookstoreService bookstoreService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.persistAuthorWithBooks();
            bookstoreService.findEbookByAuthorNameViaEbookRepository();
            bookstoreService.findEbookByAuthorNameViaBookRepository();
        };
    }
}

/*
 * 
 * 
 * How To Fetch Certain Subclass From An SINGLE_TABLE Inheritance Hierarchy

Description: This application is a sample of fetching a certain subclass from a SINGLE_TABLE inheritance hierarchy. This is useful when the dedicated repository of the subclass doesn't automatically add in the WHERE clause a dtype based condition for fetching only the needed subclass.

Key points:

explicitly add in the WHERE clause a TYPE check
 * 
 */
