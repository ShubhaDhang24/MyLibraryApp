package shubhaDhang.MyLibraryApp.Dao;

import shubhaDhang.MyLibraryApp.entity.Book;

import java.util.Collection;
import java.util.Optional;

public interface BookDao {
    Optional<Book> findById(int id);
    Collection<Book> findAll();

    Book persist(Book book);

    Book update(Book book);
    void delete(Book book);
}
