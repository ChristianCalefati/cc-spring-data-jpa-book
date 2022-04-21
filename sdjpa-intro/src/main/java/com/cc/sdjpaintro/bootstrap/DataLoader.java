package com.cc.sdjpaintro.bootstrap;

import com.cc.sdjpaintro.dao.BookRepository;
import com.cc.sdjpaintro.dao.GameRepository;
import com.cc.sdjpaintro.model.Book;
import com.cc.sdjpaintro.model.Game;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final GameRepository gameRepository;

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

        Game gta = new Game();
        gta.setPublisher("Publisher_try");
        gta.setCost(56D);
        gameRepository.save(gta);

        Game atm = new Game();
        atm.setPublisher("Publisher_try_1");
        atm.setCost(58D);
        gameRepository.save(atm);
    }
}
