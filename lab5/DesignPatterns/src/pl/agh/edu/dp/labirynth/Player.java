package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.model.Room;

public class Player {
    private int life = 10;
    private int points = 0;
    private Room currentRoom;

    public Player(Room room) {
        currentRoom = room;
    }

    public int getLife() {
        return life;
    }

    public int getPoints() {
        return points;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void decreaseLife(int val) {
        life -= val;
    }

    public void increaseLife(int val) {
        life += val;
    }

    public void increasePoints(int val) {
        points += val;
    }

    public boolean isDead() {
        return life <= 0;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    @Override
    public String toString() {
        return ("Life points: " + getLife() + " Points: " + getPoints());
    }

}
