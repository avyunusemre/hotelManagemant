package entities;

public enum Profession {

    MANAGER(4),
    RECEPTIONIST(3),
    ROOM_SERVICE(2),
    COOK(3),
    WAITER(1);

    public final int level;

    Profession(int level) {
        this.level = level;
    }

}
