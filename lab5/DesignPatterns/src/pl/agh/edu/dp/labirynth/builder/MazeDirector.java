package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.factory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.factory.NormalMazeFactory;
import pl.agh.edu.dp.labirynth.maze.Maze;
import pl.agh.edu.dp.labirynth.model.Room;

public class MazeDirector {

    public Maze createExampleMaze(MazeBuilder builder, MazeFactory mazeFactory) {
        prepareExampleMaze(builder, mazeFactory);
        return builder.build();

    }

    private void prepareExampleMaze(MazeBuilder builder, MazeFactory mazeFactory) {
        Room room1 = mazeFactory.createRoom(1);
        Room room2 = mazeFactory.createRoom(2);
        Room room3 = mazeFactory.createRoom(3);
        Room room4 = mazeFactory.createRoom(4);

        builder.addRoom(room1);
        builder.addRoom(room2);
        builder.addRoom(room3);
        builder.addRoom(room4);


        builder.setRoomWall(room1, Direction.North, mazeFactory.createWall());
        builder.setRoomWall(room1, Direction.West, mazeFactory.createWall());
        builder.setRoomWall(room2, Direction.North, mazeFactory.createWall());
        builder.setRoomWall(room2, Direction.East, mazeFactory.createWall());

        builder.setRoomWall(room3, Direction.South, mazeFactory.createWall());
        builder.setRoomWall(room3, Direction.West, mazeFactory.createWall());
        builder.setRoomWall(room4, Direction.South, mazeFactory.createWall());
        builder.setRoomWall(room4, Direction.East, mazeFactory.createWall());

        builder.joinRoomsWithAWall(room1, room2, Direction.West, mazeFactory.createWall());
        builder.joinRoomsWithAWall(room1, room3, Direction.North, mazeFactory.createWall());
        builder.joinRoomsWithAWall(room2, room4, Direction.North, mazeFactory.createWall());
        builder.joinRoomsWithAWall(room3, room4, Direction.West, mazeFactory.createWall());

        builder.addDoor(room4, room2, mazeFactory);
        builder.addDoor(room2, room1, mazeFactory);
        builder.addDoor(room1, room3, mazeFactory);
    }

    public Maze createRandomizedMaze() {
        StandardMazeBuilder builder = new StandardMazeBuilder();
        NormalMazeFactory normalMazeFactory = NormalMazeFactory.getInstance();
        EnchantedMazeFactory enchantedMazeFactory = EnchantedMazeFactory.getInstance();
        BombedMazeFactory bombedMazeFactory = BombedMazeFactory.getInstance();

        Room room1 = normalMazeFactory.createRoom(1);
        Room room2 = enchantedMazeFactory.createRoom(2);
        Room room3 = bombedMazeFactory.createRoom(3);
        Room room4 = bombedMazeFactory.createRoom(4);
        Room room5 = enchantedMazeFactory.createRoom(5);
        Room room6 = enchantedMazeFactory.createRoom(6);

        builder.addRoom(room1);
        builder.addRoom(room2);
        builder.addRoom(room3);
        builder.addRoom(room4);
        builder.addRoom(room5);
        builder.addRoom(room6);


        builder.setRoomWall(room1, Direction.South, enchantedMazeFactory.createWall());
        builder.setRoomWall(room1, Direction.East, bombedMazeFactory.createWall());
        builder.setRoomWall(room2, Direction.South, bombedMazeFactory.createWall());
        builder.setRoomWall(room5, Direction.West, bombedMazeFactory.createWall());

        builder.setRoomWall(room6, Direction.North, normalMazeFactory.createWall());
        builder.setRoomWall(room4, Direction.North, enchantedMazeFactory.createWall());


        builder.joinRoomsWithAWall(room1, room2, Direction.West, normalMazeFactory.createWall());
        builder.joinRoomsWithAWall(room1, room3, Direction.North, normalMazeFactory.createWall());
        builder.joinRoomsWithAWall(room2, room4, Direction.North, normalMazeFactory.createWall());
        builder.joinRoomsWithAWall(room3, room4, Direction.West, enchantedMazeFactory.createWall());
        builder.joinRoomsWithAWall(room2, room5, Direction.West, normalMazeFactory.createWall());
        builder.joinRoomsWithAWall(room4, room6, Direction.West, normalMazeFactory.createWall());
        builder.joinRoomsWithAWall(room6, room5, Direction.South, bombedMazeFactory.createWall());
        builder.joinRoomsWithAWall(room6, room3, Direction.West, bombedMazeFactory.createWall());

        builder.addDoor(room4, room2, normalMazeFactory);
        builder.addDoor(room2, room1, enchantedMazeFactory);
        builder.addDoor(room1, room3, normalMazeFactory);
        builder.addDoor(room4, room6, enchantedMazeFactory);
        builder.addDoor(room2, room5, enchantedMazeFactory);
        builder.addDoor(room6, room3, normalMazeFactory);

        return builder.build();
    }
}
