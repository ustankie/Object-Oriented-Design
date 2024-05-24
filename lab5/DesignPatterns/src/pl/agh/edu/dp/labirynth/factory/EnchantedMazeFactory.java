package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.model.Door;
import pl.agh.edu.dp.labirynth.model.Room;
import pl.agh.edu.dp.labirynth.model.Wall;
import pl.agh.edu.dp.labirynth.model.enchanted.EnchantedDoor;
import pl.agh.edu.dp.labirynth.model.enchanted.EnchantedRoom;
import pl.agh.edu.dp.labirynth.model.enchanted.EnchantedWall;

public class EnchantedMazeFactory implements MazeFactory {
    private static EnchantedMazeFactory instance;

    private EnchantedMazeFactory() {

    }

    public static EnchantedMazeFactory getInstance() {
        if (instance == null) {
            instance = new EnchantedMazeFactory();

        }
        return instance;
    }

    @Override
    public Room createRoom(int num) {
        return new EnchantedRoom(num);
    }

    @Override
    public Wall createWall() {
        return new EnchantedWall();
    }

    @Override
    public Door createDoor(Room room1, Room room2) {
        return new EnchantedDoor(room1, room2);
    }
}
