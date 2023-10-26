package shubhaDhang.MyLibraryApp.Dao;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import shubhaDhang.MyLibraryApp.Dao.Impl.BookDaoImpl;
import shubhaDhang.MyLibraryApp.entity.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


@SpringBootTest
@Transactional
@Rollback

public class BookDaoImplTest {
    @Autowired
    BookDaoImpl bookDao;
   private Book book1,book2;

    @BeforeEach
    public void setUp()
    {
       book1 =new Book("Test12","JavaFundamentals",20);
       book2=new Book("Test2","C#",15);
       bookDao.persist(book1);
       bookDao.persist(book2);
    }
    @Test
    public void persistTest()
    {
        Book book =new Book("Test1","JavaFundamentals",20);

        Assertions.assertNotNull(bookDao.persist(book));
    }
    @Test
    public void findByIdTest()
    {
        int id= book1.getBookId();
        Optional<Book> foundBook=bookDao.findById(id);
        //Assertions.assertNotNull(bookDao.findById(id));
        Assertions.assertEquals(id,foundBook.get().getBookId());
    }
    @Test
    public void findAllTest()
    {
        Collection<Book> allBook=bookDao.findAll();
        Assertions.assertNotNull(allBook);
        Assertions.assertEquals(2,allBook.size());

    }



}


