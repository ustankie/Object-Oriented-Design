package pl.agh.edu.dp.labirynth.model;

import pl.agh.edu.dp.labirynth.Player;

public class Door extends MapSite {
    protected Room room1;
    protected Room room2;

    public Door(Room r1, Room r2) {
        this.room1 = r1;
        this.room2 = r2;
    }


    @Override
    public void Enter(Player player) {
        System.out.println("Entering door between rooms " + room1.getRoomNumber() + " and " + room2.getRoomNumber() + "\n");
        System.out.println(player);
        if (player.getCurrentRoom().equals(getRoom1())) {
            player.setCurrentRoom(getRoom2());

        } else {
            player.setCurrentRoom(getRoom1());

        }
        player.getCurrentRoom().Enter(player);
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room1 = room2;
    }
}
