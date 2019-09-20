package local.skylerwebdev.sprintbookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.engine.internal.Cascade;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Book", description = "Book Entity")
@Entity
@Table(name = "book")
public class Book
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
    private long copy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sectionid", referencedColumnName = "sectionid")
    private Section section;

    @OneToMany(mappedBy = "book",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private List<Wrote> authorWrote = new ArrayList<>();

    public Book()
    {
    }

    public Book(String title, long isbn, long copy, Section section, List<Wrote> authorWrote)
    {
        this.title = title;
        this.isbn = isbn;
        this.copy = copy;
        this.section = section;
        for (Wrote w : authorWrote)
        {
            w.setBook(this);
        }
        this.authorWrote = authorWrote;
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

    public void setCopy(long copy)
    {
        this.copy = copy;
    }

    public Section getSection()
    {
        return section;
    }

    public void setSection(Section section)
    {
        this.section = section;
    }

    public List<Wrote> getAuthorWrote()
    {
        return authorWrote;
    }

    public void setAuthorWrote(List<Wrote> authorWrote)
    {
        this.authorWrote = authorWrote;
    }
}
