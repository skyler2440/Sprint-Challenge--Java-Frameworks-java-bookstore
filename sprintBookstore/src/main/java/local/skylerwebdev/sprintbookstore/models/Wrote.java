//package local.skylerwebdev.sprintbookstore.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity
//@Table(name = "wrote")
//public class Wrote extends Auditable implements Serializable
//{
//    private long bookid;
//    private long authorid;
//
//    public Wrote()
//    {
//    }
//
//    public Wrote(long bookid, long authorid)
//    {
//        this.bookid = bookid;
//        this.authorid = authorid;
//    }
//
//    public long getBookid()
//    {
//        return bookid;
//    }
//
//    public void setBookid(long bookid)
//    {
//        this.bookid = bookid;
//    }
//
//    public long getAuthorid()
//    {
//        return authorid;
//    }
//
//    public void setAuthorid(long authorid)
//    {
//        this.authorid = authorid;
//    }
//
//    @Override
//    public boolean equals(Object o)
//    {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Wrote wrote = (Wrote) o;
//        return bookid == wrote.bookid &&
//                authorid == wrote.authorid;
//    }
//
//    @Override
//    public int hashCode()
//    {
//        return Objects.hash(bookid, authorid);
//    }
//}
