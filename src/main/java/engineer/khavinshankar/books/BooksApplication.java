package engineer.khavinshankar.books;

import engineer.khavinshankar.books.entity.Book;
import engineer.khavinshankar.books.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@Autowired
	private BookRepository repo;

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Java", "James Gosling");
		repo.save(book1);

		Book book2 = new Book("C++", "Bjarne Stroustrup");
		repo.save(book2);
	}
}
