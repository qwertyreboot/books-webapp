package engineer.khavinshankar.books.controller;

import engineer.khavinshankar.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "books";
    }
}
