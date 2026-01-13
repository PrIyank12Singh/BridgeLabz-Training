public class Hotel {

    private Room[] rooms;
    private int count;

    public Hotel() {
        rooms = new Room[10];
        count = 0;
    }

    public void addRoom(Room room) {
        rooms[count++] = room;
        System.out.println("Room added: " + room.getRoomNumber());
    }

    public Room findAvailableRoom() {
        for (int i = 0; i < count; i++) {
            if (rooms[i].isAvailable()) {
                return rooms[i];
            }
        }
        return null;
    }
}
