package shubhaDhang.MyLibraryApp.Dao;

import shubhaDhang.MyLibraryApp.entity.BookLoan;

import java.util.Collection;
import java.util.Optional;

public interface BookLoanDao {
    Optional<BookLoan> findById(int id);
    Collection<BookLoan> findAll();
    BookLoan create( BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(BookLoan bookLoan);

}
