package pl.agh.edu.dp.labirynth.model.enchanted;

import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.model.Door;
import pl.agh.edu.dp.labirynth.model.Room;

public class EnchantedDoor extends Door {

    public EnchantedDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    @Override
    public void Enter(Player player) {
        System.out.println("Enchanted door!");
        super.Enter(player);
        player.increasePoints(1);
    }


}
