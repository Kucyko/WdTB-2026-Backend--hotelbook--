package pl.wsb.hotelbook.reservation.entity;

import jakarta.persistence.*;
import pl.wsb.hotelbook.service.entity.HotelService;

import java.math.BigDecimal;

@Entity
@Table(name = "reservation_service")
public class ReservationService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private HotelService service;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "note", length = 120)
    private String note;

    protected ReservationService() {
    }

    public ReservationService(Reservation reservation, HotelService service, Integer quantity,
                              BigDecimal unitPrice, String note) {
        this.reservation = reservation;
        this.service = service;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.note = note;
    }

    public Long getId() { return id; }
    public Reservation getReservation() { return reservation; }
    public HotelService getService() { return service; }
    public Integer getQuantity() { return quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public String getNote() { return note; }
}