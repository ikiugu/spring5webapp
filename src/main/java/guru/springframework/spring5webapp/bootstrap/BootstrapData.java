package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // create an object for each pojo
        Author alfy = new Author("Alfy", "ikiugu");
        Book book = new Book("The art of peace", "123123");

        // handle the relationships between the 2
        alfy.getBooks().add(book);
        book.getAuthors().add(alfy);

        // save each model with the repository
        authorRepository.save(alfy);
        bookRepository.save(book);

        System.out.println("Number of authors: " + authorRepository.count());

    }
}
