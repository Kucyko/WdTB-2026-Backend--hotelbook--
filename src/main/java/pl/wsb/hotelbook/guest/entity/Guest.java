package pl.wsb.hotelbook.guest.entity;

import jakarta.persistence.*;
import pl.wsb.hotelbook.account.domain.UserAccount;
import pl.wsb.hotelbook.reservation.entity.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 80)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true, length = 120)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "registered_on", nullable = false)
    private LocalDate registeredOn;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservations = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private UserAccount account;

    protected Guest() {
    }

    public Guest(String fullName, String email, String phone, LocalDate registeredOn, Address address) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.registeredOn = registeredOn;
        this.address = address;
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public LocalDate getRegisteredOn() { return registeredOn; }
    public Address getAddress() { return address; }
    public List<Reservation> getReservations() { return reservations; }
    public UserAccount getAccount() { return account; }
}