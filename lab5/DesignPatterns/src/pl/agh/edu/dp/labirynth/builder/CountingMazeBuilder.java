package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.maze.CountingMaze;
import pl.agh.edu.dp.labirynth.maze.Maze;
import pl.agh.edu.dp.labirynth.model.MapSite;
import pl.agh.edu.dp.labirynth.model.Room;
import pl.agh.edu.dp.labirynth.model.Wall;

import java.util.HashSet;
import java.util.Set;

public class CountingMazeBuilder implements MazeBuilder {
    private Set<MapSite> walls = new HashSet<>();
    private Set<MapSite> rooms = new HashSet<>();
    private Set<MapSite> doors = new HashSet<>();

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void setRoomWall(Room room, Direction direction, Wall wall) {
        if (!rooms.contains(room)) {
            throw new IllegalArgumentException("No such room!");
        }
        doors.remove(room.getSide(direction));
        walls.remove(room.getSide(direction));
        room.setSide(direction, wall);
        walls.add(wall);


    }

    @Override
    public void joinRoomsWithAWall(Room room1, Room room2, Direction direction1, Wall wall) {
        if (!rooms.contains(room1) || !rooms.contains(room2)) {
            throw new IllegalArgumentException("No such room!");
        }


        doors.remove(room1.getSide(direction1));
        doors.remove(room2.getSide(getOppositeDirection(direction1)));
        walls.remove(room1.getSide(direction1));
        walls.remove(room2.getSide(getOppositeDirection(direction1)));

        room2.setSide(getOppositeDirection(direction1), wall);
        room1.setSide(direction1, wall);
        walls.add(room1.getSide(direction1));

    }

    @Override
    public void addDoor(Room room1, Room room2, MazeFactory mazeFactory) {
        if (!rooms.contains(room1) || !rooms.contains(room2)) {
            throw new IllegalArgumentException("No such room!");
        }

        Direction room1Direction = commonWall(room1, room2);

        walls.remove(room1.getSide(room1Direction));
        walls.remove(room2.getSide(getOppositeDirection(room1Direction)));
        doors.add(mazeFactory.createDoor(room1, room2));

    }

    public Maze build() {
        return new CountingMaze(doors.size(), walls.size(), rooms.size());
    }


}
