package shubhaDhang.MyLibraryApp.entity;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback
public class AuthorTest {
    private Book book;
    private Author author1, author2;

    @BeforeEach
    public void setUp() {
        book = new Book("isbn22", "Test", 20);
        author1 = new Author("TestAuthor1", "LastAuthor");
        author2 = new Author("TestAuthor2", "LastAuthor2");

    }
    @Test
    public void addAndRemoveTest()
    {
        author1.addBook(book);
        Assertions.assertTrue(author1.getWrittenBooks().contains(book));

        author1.removeBook(book);
        Assertions.assertFalse(author1.getWrittenBooks().contains(book));
    }
}
