package me.course.spring5.spring5course.repositories;

import me.course.spring5.spring5course.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
