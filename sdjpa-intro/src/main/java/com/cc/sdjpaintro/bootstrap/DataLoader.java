package com.cc.sdjpaintro.bootstrap;

import com.cc.sdjpaintro.dao.BookRepository;
import com.cc.sdjpaintro.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Book bookDDD= new Book();
        bookDDD.setTitle("Domain Driven Design");
        bookDDD.setIsbn("123");
        bookDDD.setPublisher("RandomHouse");
        Book savedDDD = bookRepository.save(bookDDD);

        Book bookSIA= new Book();
        bookSIA.setTitle("Spring in Action");
        bookSIA.setIsbn("234");
        bookSIA.setPublisher("Oriely");
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach( book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
            System.out.println("Book isbm: " + book.getIsbn());
            System.out.println("Book publisher: " + book.getPublisher());
        });
    }
}
