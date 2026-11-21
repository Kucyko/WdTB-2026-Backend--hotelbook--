package pl.wsb.hotelbook.payment.entity;

import jakarta.persistence.*;
import pl.wsb.hotelbook.reservation.entity.Reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservation_id", nullable = false, unique = true)
    private Reservation reservation;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "method", nullable = false, length = 20)   // CARD, CASH, TRANSFER
    private String method;

    @Column(name = "paid_at", nullable = false)
    private LocalDateTime paidAt;

    @Column(name = "refunded", nullable = false)
    private Boolean refunded;

    protected Payment() {
    }

    public Payment(Reservation reservation, BigDecimal amount, String method, LocalDateTime paidAt, Boolean refunded) {
        this.reservation = reservation;
        this.amount = amount;
        this.method = method;
        this.paidAt = paidAt;
        this.refunded = refunded;
    }

    public Long getId() { return id; }
    public Reservation getReservation() { return reservation; }
    public BigDecimal getAmount() { return amount; }
    public String getMethod() { return method; }
    public LocalDateTime getPaidAt() { return paidAt; }
    public Boolean getRefunded() { return refunded; }
}
