package shubhaDhang.MyLibraryApp.Dao;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import shubhaDhang.MyLibraryApp.Dao.Impl.AuthorDaoImpl;
import shubhaDhang.MyLibraryApp.entity.Author;

import java.util.Collection;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback
public class AuthorDaoImplTest {
    @Autowired
    AuthorDaoImpl authorDao;
    Author author1, author2;


    @BeforeEach
    public void setUp() {
        author1 = new Author("TestAuthor", "TestLastName");
        author2 = new Author("Negar", "Beharmand");
        authorDao.persist(author1);
        authorDao.persist(author2);
    }

    @Test
    public void persistTest() {
        Author author = new Author("Shubha", "Dhang");
        Assertions.assertNotNull(author);
    }

    @Test
    public void findByIdTest() {
        int id = author1.getAuthorId();
        Optional<Author> foundAuthor = authorDao.findById(id);
        Assertions.assertEquals(id, foundAuthor.get().getAuthorId());
    }

    @Test
    public void findAllTest() {
        Collection<Author> foundAuthors = authorDao.findAll();
        Assertions.assertEquals(2, foundAuthors.size());
    }
}