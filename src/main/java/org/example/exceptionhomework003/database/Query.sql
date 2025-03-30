INSERT INTO attendees (attendee_name, email) VALUES
    ('Alice Johnson', 'alice@example.com'),
    ('Bob Smith', 'bob@example.com'),
    ('Charlie Brown', 'charlie@example.com'),
    ('David White', 'david@example.com'),
    ('Eve Black', 'eve@example.com'),
    ('Frank Green', 'frank@example.com'),
    ('Grace Hall', 'grace@example.com'),
    ('Henry King', 'henry@example.com'),
    ('Ivy Lee', 'ivy@example.com'),
    ('Jack Miller', 'jack@example.com');

INSERT INTO events (event_name, event_date, venue_id) VALUES
      ('Tech Conference', '2025-04-10', 1),
      ('Startup Meetup', '2025-05-15', 2),
      ('Music Festival', '2025-06-20', 3),
      ('Sports Award', '2025-07-25', 4),
      ('Film Screening', '2025-08-30', 5),
      ('Coding Bootcamp', '2025-09-05', 6),
      ('Business Summit', '2025-10-10', 7),
      ('Charity Gala', '2025-11-15', 8),
      ('Gaming Expo', '2025-12-20', 9),
      ('Science Fair', '2026-01-25', 10);

INSERT INTO event_attendee (event_id, attendee_id) VALUES
      (1, 1), (1, 2), (2, 3), (2, 4), (3, 5), (3, 6), (4, 7), (4, 8), (5, 9), (5, 10);

INSERT INTO venues (venue_name, location) VALUES
    ('Conference Hall A', 'New York'),
    ('Grand Auditorium', 'Los Angeles'),
    ('Expo Center', 'Chicago'),
    ('Convention Center', 'Houston'),
    ('City Hall', 'San Francisco'),
    ('Tech Park', 'Seattle'),
    ('University Hall', 'Boston'),
    ('Music Arena', 'Miami'),
    ('Sports Complex', 'Dallas'),
    ('Event Plaza', 'Atlanta');
