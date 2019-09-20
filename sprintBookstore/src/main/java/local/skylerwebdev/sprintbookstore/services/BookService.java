package local.skylerwebdev.sprintbookstore.services;

import local.skylerwebdev.sprintbookstore.models.Book;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface BookService
{
    ArrayList<Book> findAll(Pageable pageable);

    void delete (long id);

    Book save (Book book);

    Book update (Book book, long id);

    void addAuthor (long bookid, long authorid);
}
