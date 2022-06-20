package bookStore.example.controllers;

import bookStore.example.models.Book;
import bookStore.example.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    private BookRepository BookRepository;

    @GetMapping("/")
    public String greeting( Model model) {
        model.addAttribute("title", "Главная страница");
        Iterable<Book> books = BookRepository.findAll();
        model.addAttribute("books", books);
        return "home";
    }


}