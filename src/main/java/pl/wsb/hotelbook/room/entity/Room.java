package pl.wsb.hotelbook.room.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false, unique = true, length = 10)
    private String number;

    @Column(name = "floor", nullable = false)
    private Integer floor;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false, length = 20)
    private RoomType type;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "price_per_night", nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerNight;

    @Column(name = "available", nullable = false)
    private Boolean available;

    protected Room() {
    }

    public Room(String number, Integer floor, RoomType type, Integer capacity, BigDecimal pricePerNight, Boolean available) {
        this.number = number;
        this.floor = floor;
        this.type = type;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    public Long getId() { return id; }
    public String getNumber() { return number; }
    public Integer getFloor() { return floor; }
    public RoomType getType() { return type; }
    public Integer getCapacity() { return capacity; }
    public BigDecimal getPricePerNight() { return pricePerNight; }
    public Boolean getAvailable() { return available; }
}