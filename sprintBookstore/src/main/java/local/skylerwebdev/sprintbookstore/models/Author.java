package local.skylerwebdev.sprintbookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Author", description = "Author Entity")
@Entity
@Table(name = "author")
public class Author extends Auditable
{
    @ApiModelProperty(name = "authorid", value = "Primanry Key for Author", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    @ApiModelProperty(name = "fname", value = "First Name of Author", required = false, example = "Jane")
    private String fname;

    @ApiModelProperty(name = "lname", value = "Last Name of Author", required = false, example = "Smith")
    private String lname;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("authors")
//    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    public Author()
    {
    }

    public Author(String fname, String lname)
    {
        this.fname = fname;
        this.lname = lname;

    }

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public List<Book> getBooks()
    {
        return books;
    }

    public void setBooks(List<Book> books)
    {
        this.books = books;
    }

}
