package me.course.spring5.spring5course.bootstrap;

import me.course.spring5.spring5course.domain.Author;
import me.course.spring5.spring5course.domain.Book;
import me.course.spring5.spring5course.domain.Publisher;
import me.course.spring5.spring5course.repositories.AuthorRepository;
import me.course.spring5.spring5course.repositories.BookRepository;
import me.course.spring5.spring5course.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("PubliWubli", "Verweggiestan 12", "Breda", "NB", "3423AB");
        publisherRepository.save(publisher);
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123123");
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "234234234");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);

        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        rod.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);
        noEJB.getAuthors().add(rod);

        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count() );

        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("This publisher has a certain amount of books: " + publisher.getName() + " " + publisher.getBooks().size());
    }
}
