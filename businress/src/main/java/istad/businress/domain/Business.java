package istad.businress.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "businesses")
public class Business  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String alias;

    private String imageUrl;

    private String rating;

    private String price; // $, $$, $$$, $$$$

    private Integer reviewCount;

    private String phone;

    private String dateOpened;

    private String dateClosed;

    private Boolean isClosed;

    private Boolean isClaimed;

    private Boolean isOpening24Hours;

    @OneToMany
    private List<Category> categories;



    @ManyToMany
    @JoinTable(
            name = "business_transactions",
            joinColumns = @JoinColumn(name = "business_id"),
            inverseJoinColumns = @JoinColumn(name = "transactions_id")
    )
    private List<Transaction> transactions; // pickup, delivery and restaurant_reservation.



    @OneToMany
    private List<OpeningHour> openHours; // list of open hours for each day of the week.



}
