package shubhaDhang.MyLibraryApp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;
    @Column(nullable = false,unique = true)
    private String userName;

    private String password;
    private LocalDateTime dateTime;

    @OneToOne
    @JoinColumn(name ="detailsId")
    Details details;
    @OneToMany(mappedBy = "borrower")
    private List<BookLoan> bookLoans;

    public int getAppUserId() {
        return appUserId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Details getDetails() {
        return details;
    }

    public AppUser(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }

    public AppUser() {
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dateTime=" + dateTime +
                ", details=" + details +
                '}';
    }
}
