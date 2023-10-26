package shubhaDhang.MyLibraryApp.entity;

import jakarta.persistence.*;

import javax.naming.ldap.PagedResultsControl;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String firstName;
    private  String lastName;
   @ManyToMany
   @JoinTable(name = "AuthorBooks",joinColumns = @JoinColumn(name = "author-id"),inverseJoinColumns = @JoinColumn(name = "book-id"))
    private Set<Book> writtenBooks=new HashSet<>();

    public int getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setWrittenBooks(Set<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(int authorId, String firstName, String lastName, Set<Book> writtenBooks) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBooks = writtenBooks;
    }
    public void addBook(Book book)
    {
      writtenBooks.add(book);
      book.getAuthors().add(this);
    }
    public void removeBook(Book book)
    {
        writtenBooks.remove(book);
        book.getAuthors().remove(this);
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", writtenBooks=" + writtenBooks +
                '}';
    }
}
