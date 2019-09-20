package local.skylerwebdev.sprintbookstore.repository;

import local.skylerwebdev.sprintbookstore.models.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository <Book, Long>
{
}
