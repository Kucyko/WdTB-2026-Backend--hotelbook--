-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at)
values ('kamil.holub@student.merito.pl', 'Kamil', 'USER', current_timestamp),
       ('jan.faściszewski@student.merito.pl', 'Jan', 'USER', current_timestamp),
       ('test.test@student.merito.pl', 'Test', 'USER', current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);

-- ===== LAB 02 · room =====
insert into room (number, floor, room_type, capacity, price_per_night, available)
values ('101', 1, 'SINGLE', 1, 220.00, true),
       ('102', 1, 'DOUBLE', 2, 340.00, true),
       ('201', 2, 'DOUBLE', 3, 390.00, false),
       ('301', 3, 'SUITE', 4, 750.00, true);

-- ===== LAB 03 · guest =====
insert into guest (full_name, email, phone, registered_on, street, city, postal_code, country, user_account_id)
values ('Anna Kowalska', 'anna.kowalska@example.com', '600100200', '2026-09-15', 'Ruska 12', 'Wrocław', '50-079',
        'Polska', 1),
       ('Piotr Zieliński', 'piotr.zielinski@example.com', null, '2026-10-02', null, null, null, null, 2),
       ('Maria Lewandowska', 'maria.lew@example.com', '501300400', '2026-10-20', 'Długa 5/7', 'Kraków', '31-147',
        'Polska', null);

-- ===== LAB 03 · reservation =====
insert into reservation (reservation_number, check_in, check_out, guests_count, total_price, status, guest_id, room_id)
values ('HB-2026-0001', '2026-11-06', '2026-11-08', 1, 440.00, 'CONFIRMED', 1, 1),
       ('HB-2026-0002', '2026-11-14', '2026-11-17', 2, 1020.00, 'PENDING', 1, 2),
       ('HB-2026-0003', '2026-10-10', '2026-10-12', 4, 1500.00, 'COMPLETED', 2, 4),
       ('HB-2026-0004', '2026-12-23', '2026-12-27', 2, 1360.00, 'CANCELLED', 3, 2);

-- ===== LAB 03 · hotel_service =====
insert into hotel_service (name, price, description, available) values
       ('Śniadanie', 45.00, 'Bufet śniadaniowy', true),
       ('Parking', 30.00, 'Miejsce na parkingu podziemnym', true),
       ('Spa', 120.00, 'Wejście do strefy spa', true);

-- ===== LAB 03 · payment =====
insert into payment (reservation_id, amount, method, paid_at, refunded) values
       (1, 440.00, 'CARD', '2026-11-01 10:15:00', false),
       (2, 500.00, 'TRANSFER', '2026-11-10 09:00:00', false),
       (3, 1500.00, 'CARD', '2026-10-01 18:30:00', false);

-- ===== LAB 03 · reservation_service =====
insert into reservation_service (reservation_id, service_id, quantity, unit_price, note) values
       (1, 1, 2, 45.00, null),
       (2, 1, 2, 45.00, 'bez laktozy'),
       (2, 2, 1, 30.00, null);