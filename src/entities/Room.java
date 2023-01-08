package entities;

import java.time.LocalDateTime;

public class Room {
    private Long id;
    private Long roomNumber;
    private RoomType type;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}
