package shubhaDhang.MyLibraryApp.Dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import shubhaDhang.MyLibraryApp.Dao.BookDao;
import shubhaDhang.MyLibraryApp.entity.Book;

import java.util.Collection;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Optional<Book> findById(int id) {
        Book foundBook=entityManager.find(Book.class,id);
        return Optional.ofNullable(foundBook);
    }

    @Override
    public Collection<Book> findAll() {
        return entityManager.createQuery("select  B from Book B", Book.class).getResultList();
    }

    @Override
    @Transactional
    public Book persist(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    @Transactional
    public Book update(Book book) {
        return  entityManager.merge(book);
    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book);
    }
}
