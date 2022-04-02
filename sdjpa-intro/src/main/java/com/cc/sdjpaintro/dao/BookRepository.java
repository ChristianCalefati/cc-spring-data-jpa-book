package com.cc.sdjpaintro.dao;

import com.cc.sdjpaintro.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
