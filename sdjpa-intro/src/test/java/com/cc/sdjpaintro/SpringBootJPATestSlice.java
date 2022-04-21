package com.cc.sdjpaintro;

import com.cc.sdjpaintro.dao.BookRepository;
import com.cc.sdjpaintro.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class SpringBootJPATestSlice {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testJpaTestSlice(){
        long countBefore = bookRepository.count();

        bookRepository.save(new Book("123L", "MyBook", "1235555","Self"));

        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }
}
