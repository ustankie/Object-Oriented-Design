package pl.agh.edu.dp.labirynth.maze;

import pl.agh.edu.dp.labirynth.model.Room;

import java.util.Vector;

public class Maze {
    private Vector<Room> rooms;

    public Maze(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public Maze() {
        this.rooms = new Vector<Room>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public Vector<Room> getRooms() {
        return rooms;
    }

    public int getRoomNumbers() {
        return rooms.size();
    }

    public Room getStartRoom() {
        return rooms.get(0);
    }
}
