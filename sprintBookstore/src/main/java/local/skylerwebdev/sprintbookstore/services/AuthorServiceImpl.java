package local.skylerwebdev.sprintbookstore.services;

import local.skylerwebdev.sprintbookstore.models.Author;
import local.skylerwebdev.sprintbookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> findAll(Pageable pageable)
    {
        List<Author> list = new ArrayList<>();
        authorRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id)
    {

    }

    @Override
    public Author save(Author author)
    {
        return null;
    }

    @Override
    public Author update(Author author, long id, boolean isAdmin)
    {
        return null;
    }
}
