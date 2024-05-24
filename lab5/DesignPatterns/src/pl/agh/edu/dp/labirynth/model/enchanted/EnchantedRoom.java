package pl.agh.edu.dp.labirynth.model.enchanted;

import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.model.Room;

public class EnchantedRoom extends Room {

    public EnchantedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter(Player player) {
        System.out.println("Entering enchanted room " + getRoomNumber() + "...");
        player.increasePoints(3);
        System.out.println(player);
    }
}
