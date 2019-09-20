package local.skylerwebdev.sprintbookstore.services;

import local.skylerwebdev.sprintbookstore.models.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService
{
    List<Author> findAll(Pageable pageable);

    void delete (long id);

    Author save (Author author);

    Author update (Author author, long id, boolean isAdmin);
}
