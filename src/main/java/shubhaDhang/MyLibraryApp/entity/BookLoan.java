package shubhaDhang.MyLibraryApp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private boolean returned;
    @ManyToOne
    @JoinColumn(name = "appUserId")
    AppUser borrower;
    @ManyToOne
    @JoinColumn(name = "bookId")
    Book book;

    public int getLoanId() {
        return loanId;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public AppUser getBorrower() {
        return borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookLoan() {
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "loanId=" + loanId +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                ", borrower=" + borrower +
                ", book=" + book +
                '}';
    }
}
