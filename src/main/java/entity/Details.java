package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;
    @Column(nullable = false,unique = true)
    private String email;

    private String  name;
    private LocalDateTime birthDate;




}
