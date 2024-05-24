package pl.agh.edu.dp.labirynth.model.bombed;

import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.model.Room;

public class BombedRoom extends Room {
    public BombedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter(Player player) {
        System.out.println("Entering bombed room " + getRoomNumber() + "...");
        player.decreaseLife(3);
        System.out.println(player);
    }
}
