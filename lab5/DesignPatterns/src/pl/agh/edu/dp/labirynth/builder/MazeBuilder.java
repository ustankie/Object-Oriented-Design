package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.maze.Maze;
import pl.agh.edu.dp.labirynth.model.Room;
import pl.agh.edu.dp.labirynth.model.Wall;

public interface MazeBuilder {
    void addRoom(Room room);

    void setRoomWall(Room room, Direction direction, Wall wall);

    void joinRoomsWithAWall(Room room1, Room room2, Direction direction1, Wall wall);

    void addDoor(Room room1, Room room2, MazeFactory mazeFactory);

    Maze build();

    default Direction getOppositeDirection(Direction direction) {
        return switch (direction) {
            case East -> Direction.West;
            case West -> Direction.East;
            case North -> Direction.South;
            case South -> Direction.North;
        };
    }

    default Direction commonWall(Room room1, Room room2) {
        for (Direction direction : Direction.values()) {
            Direction oppositeDirection = getOppositeDirection(direction);
            if (room1.getSide(direction) != null && room2.getSide(oppositeDirection) != null && room1.getSide(direction).equals(room2.getSide(oppositeDirection))) {
                return direction;
            }
        }
        throw new IllegalArgumentException("Rooms don't have common wall!");
    }
}
