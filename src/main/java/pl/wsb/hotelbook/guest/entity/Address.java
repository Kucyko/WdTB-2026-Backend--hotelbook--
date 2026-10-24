package pl.wsb.hotelbook.guest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "street", length = 80)
    private String street;

    @Column(name = "city", length = 40)
    private String city;

    @Column(name = "postal_code", length = 6)
    private String postalCode;

    @Column(name = "country", length = 40)
    private String country;

    protected Address() {
    }

    public Address(String street, String city, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }
}