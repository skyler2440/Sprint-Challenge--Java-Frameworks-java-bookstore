package local.skylerwebdev.sprintbookstore.controllers;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import local.skylerwebdev.sprintbookstore.models.Author;
import local.skylerwebdev.sprintbookstore.services.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController
{
    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    AuthorService authorService;

    @ApiOperation(value = "Return All Authors with Paging and Sorting", response = Author.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "int", paramType = "query",
                    value = "Results page you want to retrieve(0..N)"),
            @ApiImplicitParam(name = "size", dataType = "int", paramType = "query",
                    value = "Number of records per page"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria supported")})
    @GetMapping(value = "/authors", produces = {"application/json"})
    public ResponseEntity<?> listAllAuthors(HttpServletRequest request, @PageableDefault(page = 0, size = 3)Pageable pageable)
    {
        logger.trace(request.getMethod().toUpperCase()+ " "+ request.getRequestURI()+ " accessed");
        List<Author> authors = authorService.findAll(pageable);
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}
