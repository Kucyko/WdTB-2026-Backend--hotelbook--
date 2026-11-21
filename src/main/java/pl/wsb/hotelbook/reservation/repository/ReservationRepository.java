package pl.wsb.hotelbook.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.hotelbook.reservation.entity.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByGuest_FullName(String fullName);
    List<Reservation> findByRoom_Number(String roomNumber);
}
