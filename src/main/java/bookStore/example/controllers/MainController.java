package bookStore.example.controllers;

import bookStore.example.models.Book;
import bookStore.example.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MainController {

    @Autowired
    private BookRepository BookRepository;

    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "Главная страница");
        Iterable<Book> books = BookRepository.findAll();
        model.addAttribute("books", books);
        return "home";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String book(@PathVariable("id") Long Id, Model model) {

        Book books = BookRepository.getFirstById(Id);

        model.addAttribute("book", books);

        return "book";
    }




}