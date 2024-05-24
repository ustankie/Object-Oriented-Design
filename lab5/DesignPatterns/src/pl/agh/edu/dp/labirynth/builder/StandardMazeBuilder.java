package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.maze.Maze;
import pl.agh.edu.dp.labirynth.model.Door;
import pl.agh.edu.dp.labirynth.model.Room;
import pl.agh.edu.dp.labirynth.model.Wall;

import java.util.List;
import java.util.Vector;

public class StandardMazeBuilder implements MazeBuilder {
    private Vector<Room> rooms = new Vector<>();

    public StandardMazeBuilder() {
        super();
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void setRoomWall(Room room, Direction direction, Wall wall) {
        if (!rooms.contains(room)) {
            throw new IllegalArgumentException("No such room in your map, first add it!");
        }
        room.setSide(direction, wall);
    }

    @Override
    public void joinRoomsWithAWall(Room room1, Room room2, Direction direction1, Wall wall) {
        room2.setSide(getOppositeDirection(direction1), wall);
        room1.setSide(direction1, wall);
    }

    @Override
    public void addDoor(Room room1, Room room2, MazeFactory mazeFactory) {
        Door door = mazeFactory.createDoor(room1, room2);

        Direction room1Direction = commonWall(room1, room2);
        Direction room2Direction = getOppositeDirection(room1Direction);

        room1.setSide(room1Direction, door);
        room2.setSide(room2Direction, door);
    }


    public List<Room> getRooms() {
        return rooms;
    }

    public Maze build() {
        return new Maze(rooms);
    }


}
