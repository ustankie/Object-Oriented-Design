package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.model.Door;
import pl.agh.edu.dp.labirynth.model.Room;
import pl.agh.edu.dp.labirynth.model.Wall;

public interface MazeFactory {
    Room createRoom(int num);

    Wall createWall();

    Door createDoor(Room room1, Room room2);

}
