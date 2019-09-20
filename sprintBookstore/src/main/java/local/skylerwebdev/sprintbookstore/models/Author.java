package local.skylerwebdev.sprintbookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Author", description = "Author Entity")
@Entity
@Table(name = "author")
public class Author
{
    @ApiModelProperty(name = "authorid", value = "Primanry Key for Author", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    @ApiModelProperty(name = "fname", value = "First Name of Author", required = false, example = "Jane")
    private String fname;

    @ApiModelProperty(name = "lname", value = "Last Name of Author", required = false, example = "Smith")
    private String lname;

    @OneToMany(mappedBy = "author",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties("author")
    private List<Wrote> authorWrote = new ArrayList<>();

    public Author()
    {
    }

    public Author(String fname, String lname, List<Wrote> authorWrote)
    {
        this.fname = fname;
        this.lname = lname;
        for (Wrote w : authorWrote)
        {
            w.setAuthor(this);
        }
        this.authorWrote = authorWrote;
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

    public List<Wrote> getAuthorWrote()
    {
        return authorWrote;
    }

    public void setAuthorWrote(List<Wrote> authorWrote)
    {
        this.authorWrote = authorWrote;
    }
}
