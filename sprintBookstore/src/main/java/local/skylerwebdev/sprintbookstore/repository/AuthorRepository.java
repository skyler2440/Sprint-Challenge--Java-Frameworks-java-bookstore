package local.skylerwebdev.sprintbookstore.repository;

import local.skylerwebdev.sprintbookstore.models.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long>
{
}
