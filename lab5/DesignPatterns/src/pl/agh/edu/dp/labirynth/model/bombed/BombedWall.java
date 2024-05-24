package pl.agh.edu.dp.labirynth.model.bombed;

import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.model.Wall;

public class BombedWall extends Wall {
    @Override
    public void Enter(Player player) {
        System.out.println("A bombed wall");
        player.decreaseLife(2);
        System.out.println(player);
    }
}
