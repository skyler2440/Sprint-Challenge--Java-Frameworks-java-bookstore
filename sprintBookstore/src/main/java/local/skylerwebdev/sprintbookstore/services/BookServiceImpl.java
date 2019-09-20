package local.skylerwebdev.sprintbookstore.services;

import local.skylerwebdev.sprintbookstore.exceptions.ResourceNotFoundException;
import local.skylerwebdev.sprintbookstore.models.Book;
import local.skylerwebdev.sprintbookstore.repository.AuthorRepository;
import local.skylerwebdev.sprintbookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public ArrayList<Book> findAll(Pageable pageable)
    {
        ArrayList<Book> list = new ArrayList<>();
        bookRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id)
    {
     if(bookRepository.findById(id).isPresent())
     {
         bookRepository.deleteById(id);
     }
     else throw new ResourceNotFoundException(Long.toString(id));
    }

    @Override
    public Book save(Book book)
    {
//        Book newBook = new Book();
//
//        newRestaurant.setName(restaurant.getName());
//        newRestaurant.setAddress(restaurant.getAddress());
//        newRestaurant.setCity(restaurant.getCity());
//        newRestaurant.setState(restaurant.getState());
//        newRestaurant.setTelephone(restaurant.getTelephone());
//
//        ArrayList<RestaurantPayments> newPayments = new ArrayList<>();
//        for (RestaurantPayments rp : restaurant.getRestaurantPayments())
//        {
//            newPayments.add(new RestaurantPayments(newRestaurant, rp.getPayment()));
//        }
//        newRestaurant.setRestaurantPayments(newPayments);
//
//        for (Menu m : restaurant.getMenus())
//        {
//            newRestaurant.getMenus().add(new Menu(m.getDish(), m.getPrice(), newRestaurant));
//        }
//
//        return restrepos.save(newRestaurant);
        return null;
    }
    @Transactional
    @Override
    public Book update(Book book, long id)
    {
        Book currentBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));

        if (book.getTitle() != null)
        {
            currentBook.setTitle(book.getTitle());
        }

        if (book.getIsbn() > 0)
        {
            currentBook.setIsbn(book.getIsbn());
        }

        if (book.getCopy() > 0)
        {
            currentBook.setCopy(book.getCopy());
        }

        return bookRepository.save(currentBook);
    }

    @Transactional
    @Override
    public void addAuthor(long bookid, long authorid)
    {
        bookRepository.findById(bookid).orElseThrow(() -> new ResourceNotFoundException("Book id " + bookid + " not found!"));
        authorRepository.findById(authorid).orElseThrow(() -> new ResourceNotFoundException("Author id " + authorid + " not found!"));

        if(bookRepository.checkAuthorCombo(bookid, authorid).getCount() <= 0)
        {
            bookRepository.insertAuthors(bookid, authorid);
        } else
        {
            throw new ResourceNotFoundException("Author Book Combo Already Exists");
        }

    }
}
