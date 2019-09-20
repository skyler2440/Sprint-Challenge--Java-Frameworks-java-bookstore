package local.skylerwebdev.sprintbookstore.repository;

import local.skylerwebdev.sprintbookstore.view.JustTheCount;
import local.skylerwebdev.sprintbookstore.models.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends PagingAndSortingRepository <Book, Long>
{
    @Query(value = "SELECT COUNT(*) as count FROM wrote WHERE authorid = :authorid AND bookid = :bookid", nativeQuery = true)
    JustTheCount checkAuthorCombo(long authorid, long bookid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO wrote(bookid, authorid) VALUES(:bookid, :authorid)", nativeQuery = true)
    void insertAuthors(long bookid, long authorid);
}
