package local.skylerwebdev.sprintbookstore.controllers;

import io.swagger.annotations.*;
import local.skylerwebdev.sprintbookstore.models.Book;
import local.skylerwebdev.sprintbookstore.models.ErrorDetail;
import local.skylerwebdev.sprintbookstore.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("/books")
public class BookController
{
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @ApiOperation(value = "Returns all Books", response = Book.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks(HttpServletRequest request, @PageableDefault(page = 0, size = 3)Pageable pageable)
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        ArrayList<Book> books = bookService.findAll(pageable);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @ApiOperation(value = "Updates a book based on id", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book Updated Successfully", response = void.class),
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateBook(
            HttpServletRequest request,
            @RequestBody
            Book updateBook,
            @PathVariable long id)
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        bookService.update(updateBook, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes a book based on id", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book Deleted Successfully", response = void.class),
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBook(HttpServletRequest request, @PathVariable long id)
    {
        logger.trace(request.getMethod().toUpperCase()+ " " + request.getRequestURI()+ " accessed");
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Updates Author For Book", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Author Created Successfully", response = void.class),
            @ApiResponse(code = 500, message = "ERROR Creating Author", response = ErrorDetail.class)
    })
    @PostMapping("/{bookid}/authors/{authorid}")
    public ResponseEntity<?> addAuthorById(HttpServletRequest request, @PathVariable long bookid, @PathVariable long authorid)
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        bookService.addAuthor(bookid, authorid);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}