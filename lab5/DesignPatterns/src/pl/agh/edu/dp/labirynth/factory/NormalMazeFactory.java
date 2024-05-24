package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.model.Door;
import pl.agh.edu.dp.labirynth.model.Room;
import pl.agh.edu.dp.labirynth.model.Wall;


public class NormalMazeFactory implements MazeFactory {
    private static NormalMazeFactory instance;

    private NormalMazeFactory() {

    }

    public static NormalMazeFactory getInstance() {
        if (instance == null) {
            instance = new NormalMazeFactory();

        }
        return instance;
    }

    @Override
    public Room createRoom(int num) {
        return new Room(num);
    }

    @Override
    public Wall createWall() {
        return new Wall();
    }

    @Override
    public Door createDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }
}
