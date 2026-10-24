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

-- ===== LAB 02 · guest =====
insert into guest (full_name, email, phone, registered_on, street, city, postal_code, country)
values ('Anna Kowalska', 'anna.kowalska@example.com', '600100200', '2026-09-15', 'Ruska 12', 'Wrocław', '50-079',
        'Polska'),
       ('Piotr Zieliński', 'piotr.zielinski@example.com', null, '2026-10-02', null, null, null, null),
       ('Maria Lewandowska', 'maria.lew@example.com', '501300400', '2026-10-20', 'Długa 5/7', 'Kraków', '31-147',
        'Polska');

-- ===== LAB 02 · reservation =====
insert into reservation (reservation_number, check_in, check_out, guests_count, total_price, status)
values ('HB-2026-0001', '2026-11-06', '2026-11-08', 1, 440.00, 'CONFIRMED'),
       ('HB-2026-0002', '2026-11-14', '2026-11-17', 2, 1020.00, 'PENDING'),
       ('HB-2026-0003', '2026-10-10', '2026-10-12', 4, 1500.00, 'COMPLETED'),
       ('HB-2026-0004', '2026-12-23', '2026-12-27', 2, 1360.00, 'CANCELLED');