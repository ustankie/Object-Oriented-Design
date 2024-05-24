package pl.agh.edu.dp.labirynth.model.enchanted;

import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.model.Wall;

public class EnchantedWall extends Wall {
    @Override
    public void Enter(Player player) {
        System.out.println("An enchanted wall");
        player.increasePoints(2);
        System.out.println(player);
    }
}
