package example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller("/books")
public class BookController {
    private final Map<String, Book> books = new ConcurrentHashMap<>();

    public BookController() {
        books.put("The Stand", new Book("The Stand", 1000));
        books.put("The Shining", new Book("The Shining", 400));
    }

    @Get("/")
    Collection<Book> books() {
        return books.values();
    }

    @Post("/")
    Book save(@Valid Book book) {
        this.books.put(book.getName(), book);
        return book;
    }

    @Delete("/{title}")
    Book delete(@NotBlank String title) {
        return books.remove(title);
    }
}
