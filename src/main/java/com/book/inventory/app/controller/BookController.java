package com.book.inventory.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.inventory.app.domain.Book;
import com.book.inventory.app.repo.BookRepo;

@Controller
public class BookController {

    @Autowired
    private BookRepo repo;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addBook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/addBook")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        try {
            repo.save(book);
            model.addAttribute("message", "Book added successfully!");
            model.addAttribute("book", new Book());
        } catch (Exception e) {
            model.addAttribute("error", "Failed to add book: " + e.getMessage());
        }
        return "addbook";
    }

    @GetMapping("/search")
    public String showSearchForm() {
        return "searchbook";
    }

    @PostMapping("/search")
    public String searchBook(@RequestParam("bookid") String bookid, Model model) {
        Book book = repo.findByBookid(bookid);
        if (book != null) {
            model.addAttribute("book", book);
        } else {
            model.addAttribute("errorMessage", "Book not found with ID: " + bookid);
        }
        return "searchbook";
    }

    @GetMapping("/deleteBook")
    public String showDeleteForm() {
        return "deletebook";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookid") String bookid, Model model) {
        Book book = repo.findByBookid(bookid);
        if (book != null) {
            repo.deleteByBookid(bookid);
            model.addAttribute("successMessage", "Book with ID " + bookid + " deleted successfully.");
        } else {
            model.addAttribute("errorMessage", "Book not found with ID: " + bookid);
        }
        return "deletebook";
    }

    @GetMapping("/info")
    public String getInfo(Model model) {
        List<Book> books = repo.findAll();

        long totalBooks = books.stream()
                .mapToLong(b -> {
                    try {
                        return Long.parseLong(b.getQuantity());
                    } catch (Exception e) {
                        return 1;
                    }
                }).sum();

        double totalBooksPrice = books.stream()
                .mapToDouble(b -> {
                    try {
                        return b.getPrice() * Integer.parseInt(b.getQuantity());
                    } catch (Exception e) {
                        return b.getPrice();
                    }
                }).sum();

        long totalAuthors = books.stream()
                .map(Book::getAuthor)
                .filter(a -> a != null && !a.trim().isEmpty())
                .distinct()
                .count();

        model.addAttribute("books", books);
        model.addAttribute("totalBooks", totalBooks);
        model.addAttribute("totalBooksPrice", totalBooksPrice);
        model.addAttribute("totalAuthors", totalAuthors);

        return "bookinfo";
    }
}