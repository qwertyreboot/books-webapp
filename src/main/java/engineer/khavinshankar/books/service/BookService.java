package engineer.khavinshankar.books.service;

import engineer.khavinshankar.books.entity.Book;
import engineer.khavinshankar.books.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book saveBook(Book book) {
        return repo.save(book);
    }

    public Book getBookById(Long id) {
        return repo.getById(id);
    }
}
