package pl.agh.edu.dp.labirynth.model;

import pl.agh.edu.dp.labirynth.Player;

public class Wall extends MapSite {
    public Wall() {

    }

    @Override
    public void Enter(Player player) {
        System.out.println("A wall\n");
        System.out.println(player);

    }
}
