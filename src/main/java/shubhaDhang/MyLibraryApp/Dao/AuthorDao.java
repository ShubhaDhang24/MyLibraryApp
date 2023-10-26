package shubhaDhang.MyLibraryApp.Dao;

import shubhaDhang.MyLibraryApp.entity.Author;
import shubhaDhang.MyLibraryApp.entity.Book;

import java.util.Collection;
import java.util.Optional;

public interface AuthorDao {
    Author persist(Author author);
    Author update(Author author);
    void delete(Author author);
    Optional<Author> findById(int id);
    Collection<Author>findAll();
}
