package me.course.spring5.spring5course.repositories;

import me.course.spring5.spring5course.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
