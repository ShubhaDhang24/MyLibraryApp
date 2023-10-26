package shubhaDhang.MyLibraryApp.Dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shubhaDhang.MyLibraryApp.Dao.BookLoanDao;
import shubhaDhang.MyLibraryApp.entity.BookLoan;

import java.util.Collection;
import java.util.Optional;

@Repository
public class BookLoanDaoImpl implements BookLoanDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<BookLoan> findById(int id) {
           BookLoan foundBook=entityManager.find(BookLoan.class,id);
        return Optional.ofNullable(foundBook);
    }

    @Override
    public Collection<BookLoan> findAll() {
        return  entityManager.createQuery("select B from BookLoan B", BookLoan.class).getResultList();
    }

    @Override
    public BookLoan create(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return  bookLoan;
    }

    @Override
    public BookLoan update(BookLoan bookLoan) {
        entityManager.merge(bookLoan);
        return bookLoan;
    }

    @Override
    public void delete(BookLoan bookLoan) {
        entityManager.remove(bookLoan);
    }
}
