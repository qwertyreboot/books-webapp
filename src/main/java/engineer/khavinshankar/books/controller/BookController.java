package engineer.khavinshankar.books.controller;

import engineer.khavinshankar.books.entity.Book;
import engineer.khavinshankar.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "books";
    }

    @GetMapping("/books/new")
    public String addBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "add_book";
    }

    @PostMapping("/books/new")
    public String addBook(@ModelAttribute("book") Book book) {
        service.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", service.getBookById(id));
        return "edit_book";
    }

    @PostMapping("/books/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute("book") Book book) {
        Book exbook = service.getBookById(id);
        exbook.setName(book.getName());
        exbook.setAuthor(book.getAuthor());

        service.saveBook(exbook);
        return "redirect:/books";
    }
}
