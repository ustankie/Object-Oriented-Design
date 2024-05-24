package pl.agh.edu.dp.labirynth.maze;

public class CountingMaze extends Maze {
    private int doors;
    private int walls;
    private int rooms;

    public CountingMaze(int doors, int walls, int rooms) {
        this.doors = doors;
        this.walls = walls;
        this.rooms = rooms;
    }


    public int getDoorNumber() {
        return doors;
    }

    public int getWallNumber() {
        return walls;
    }

    public int getRoomNumber() {
        return rooms;
    }

}
