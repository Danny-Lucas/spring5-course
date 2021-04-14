package me.course.spring5.spring5course.repositories;

import me.course.spring5.spring5course.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
