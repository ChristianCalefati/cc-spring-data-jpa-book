package com.cc.sdjpaintro.model;

import com.cc.sdjpaintro.model.sequencegenerators.StringPrefixSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GenericGenerator(name = "book_id_generator",
            strategy = "com.cc.sdjpaintro.model.sequencegenerators.StringPrefixSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixSequenceIdGenerator.VALUE_PREFIX_PARAM, value = "B_"),
                    @Parameter(name = StringPrefixSequenceIdGenerator.NUMBER_FORMAT_PARAM, value = "%05d")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_generator")
    private String id;

    private String title;
    private String isbn;
    private String publisher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return id != null && Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
