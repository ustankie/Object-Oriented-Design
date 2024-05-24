package pl.agh.edu.dp.labirynth.model.bombed;

import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.model.Door;
import pl.agh.edu.dp.labirynth.model.Room;

public class BombedDoor extends Door {
    public BombedDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    @Override
    public void Enter(Player player) {
        System.out.println("Bombed door!");
        super.Enter(player);
        player.decreaseLife(1);


    }
}
