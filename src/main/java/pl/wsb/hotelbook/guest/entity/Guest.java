package pl.wsb.hotelbook.guest.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

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
}