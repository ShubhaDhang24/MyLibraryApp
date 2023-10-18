package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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


}
