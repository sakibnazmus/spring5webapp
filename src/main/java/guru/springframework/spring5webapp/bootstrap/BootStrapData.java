package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repostitories.AuthorRepository;
import guru.springframework.spring5webapp.repostitories.BookRepository;
import guru.springframework.spring5webapp.repostitories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Publisher pathokSomabesh = new Publisher("Pathok Shomabesh", "Aziz Market",
                "Dhaka", "Dhaka", "1220");
        publisherRepository.save(pathokSomabesh);

        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Desing", "570631-4505");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);
        book1.setPublisher(pathokSomabesh);
        pathokSomabesh.getBooks().add(book1);

        authorRepository.save(eric);
        bookRepository.save(book1);
        publisherRepository.save(pathokSomabesh);

        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "0760324509624");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);
        book2.setPublisher(pathokSomabesh);
        pathokSomabesh.getBooks().add(book2);

        authorRepository.save((rod));
        bookRepository.save(book2);
        publisherRepository.save(pathokSomabesh);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

        System.out.println("Number of books published by " + pathokSomabesh.getName() +
                ": " + pathokSomabesh.getBooks().size());
    }
}
