package local.skylerwebdev.sprintbookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Book", description = "Book Entity")
@Entity
@Table(name = "book")
public class Book extends Auditable
{
    @ApiModelProperty(name = "bookid", value = "Primary Key for Book", required = true, example = "false")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @ApiModelProperty(name = "title", value = "Title of Book", required = false, example = "Where the Red Fern Grows")
    private String title;

    @ApiModelProperty(name = "isbn", value = "ISBN of Book", required = false, example = "1234567891234")
    private long isbn;

    @ApiModelProperty(name = "copy", value = "Copyright year of Book", required = false, example = "2010")
    @Column(nullable = true)
    private Long copy;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    @JoinTable(name="wrote",
    joinColumns = @JoinColumn(name = "bookid"),
    inverseJoinColumns = @JoinColumn(name = "authorid"))
    @JsonIgnoreProperties("books")
//    @JsonIgnore
    private List<Author> authors = new ArrayList<>();
    public Book()
    {
    }

    public Book(String title, long isbn, Long copy)
    {
        this.title = title;
        this.isbn = isbn;
        this.copy = copy;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public long getIsbn()
    {
        return isbn;
    }

    public void setIsbn(long isbn)
    {
        this.isbn = isbn;
    }

    public long getCopy()
    {
        return copy;
    }

    public void setCopy(Long copy)
    {
        this.copy = copy;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Author> authors)
    {
        this.authors = authors;
    }
}
