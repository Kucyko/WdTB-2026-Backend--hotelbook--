package pl.wsb.hotelbook.service.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "hotel_service")
public class HotelService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "available", nullable = false)
    private Boolean available;

    protected HotelService() {
    }

    public HotelService(String name, BigDecimal price, String description, Boolean available) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.available = available;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public String getDescription() { return description; }
    public Boolean getAvailable() { return available; }
}
