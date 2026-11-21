# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 7 · kolumny: 48 · relacje: 4 × @ManyToOne, 2 × @OneToMany, 2 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| guest | Guest | 10 | user_account_id |
| hotel_service | HotelService | 5 | — |
| payment | Payment | 6 | reservation_id |
| reservation | Reservation | 9 | guest_id, room_id |
| reservation_service | ReservationService | 6 | reservation_id, service_id |
| room | Room | 7 | — |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    guest {
        Long id PK
        String city
        String country
        String email
        String full_name
        String phone
        String postal_code
        LocalDate registered_on
        String street
        Long user_account_id FK
    }
    hotel_service {
        Long id PK
        Boolean available
        String description
        String name
        BigDecimal price
    }
    payment {
        Long id PK
        BigDecimal amount
        String method
        LocalDateTime paid_at
        Boolean refunded
        Long reservation_id FK
    }
    reservation {
        Long id PK
        LocalDate check_in
        LocalDate check_out
        Long guest_id FK
        Integer guests_count
        String reservation_number
        Long room_id FK
        ReservationStatus status
        BigDecimal total_price
    }
    reservation_service {
        Long id PK
        String note
        Integer quantity
        Long reservation_id FK
        Long service_id FK
        BigDecimal unit_price
    }
    room {
        Long id PK
        Boolean available
        Integer capacity
        Integer floor
        String number
        BigDecimal price_per_night
        RoomType room_type
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    guest ||--o{ reservation : "guest_id"
    hotel_service ||--o{ reservation_service : "service_id"
    reservation ||--o{ reservation_service : "reservation_id"
    reservation ||--o| payment : "reservation_id"
    room ||--o{ reservation : "room_id"
    user_account |o--o| guest : "user_account_id"
```
