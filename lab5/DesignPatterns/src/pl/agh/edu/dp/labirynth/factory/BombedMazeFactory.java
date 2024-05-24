package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.model.Door;
import pl.agh.edu.dp.labirynth.model.Room;
import pl.agh.edu.dp.labirynth.model.Wall;
import pl.agh.edu.dp.labirynth.model.bombed.BombedDoor;
import pl.agh.edu.dp.labirynth.model.bombed.BombedRoom;
import pl.agh.edu.dp.labirynth.model.bombed.BombedWall;

public class BombedMazeFactory implements MazeFactory {
    private static BombedMazeFactory instance;

    private BombedMazeFactory() {

    }

    public static BombedMazeFactory getInstance() {
        if (instance == null) {
            instance = new BombedMazeFactory();

        }
        return instance;
    }

    @Override
    public Room createRoom(int num) {
        return new BombedRoom(num);
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }

    @Override
    public Door createDoor(Room room1, Room room2) {
        return new BombedDoor(room1, room2);
    }
}
