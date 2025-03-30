CREATE TABLE venues (
    venue_id SERIAL PRIMARY KEY,
    venue_name VARCHAR(255) NOT NULL,
    location TEXT NOT NULL
);
CREATE TABLE events (
    event_id SERIAL PRIMARY KEY,
    event_name VARCHAR(255) NOT NULL,
    event_date DATE NOT NULL,
    venue_id INT REFERENCES venues(venue_id) ON DELETE CASCADE
);


CREATE TABLE attendees (
   attendee_id SERIAL PRIMARY KEY,
   attendee_name VARCHAR(255) NOT NULL,
   email VARCHAR(255) UNIQUE NOT NULL
);


CREATE TABLE event_attendee (
    id SERIAL PRIMARY KEY,
    event_id INT REFERENCES events(event_id) ON DELETE CASCADE,
    attendee_id INT REFERENCES attendees(attendee_id) ON DELETE CASCADE
);