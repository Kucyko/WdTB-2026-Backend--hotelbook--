package pl.wsb.hotelbook.reservation.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import pl.wsb.hotelbook.guest.entity.Guest;
import pl.wsb.hotelbook.room.entity.Room;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservation_number", nullable = false, unique = true, length = 20)
    private String reservationNumber;

    @Column(name = "check_in", nullable = false)
    private LocalDate checkIn;

    @Column(name = "check_out", nullable = false)
    private LocalDate checkOut;

    @Column(name = "guests_count", nullable = false)
    private Integer guestsCount;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ReservationStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    protected Reservation() {
    }

    public Reservation(String reservationNumber, LocalDate checkIn, LocalDate checkOut, Integer guestsCount,
                       BigDecimal totalPrice, ReservationStatus status, Guest guest, Room room) {
        this.reservationNumber = reservationNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guestsCount = guestsCount;
        this.totalPrice = totalPrice;
        this.status = status;
        this.guest = guest;
        this.room = room;
    }

    public Long getId() { return id; }
    public String getReservationNumber() { return reservationNumber; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public Integer getGuestsCount() { return guestsCount; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public ReservationStatus getStatus() { return status; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }

}