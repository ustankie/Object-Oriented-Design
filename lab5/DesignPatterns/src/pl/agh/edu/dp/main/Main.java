package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.labirynth.builder.StandardMazeBuilder;
import pl.agh.edu.dp.labirynth.factory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.maze.Maze;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MazeGame mazeGame = new MazeGame();
        StandardMazeBuilder builder = new StandardMazeBuilder();
        MazeFactory mazeFactory = BombedMazeFactory.getInstance();
        Maze maze = mazeGame.createRandomizedMaze(builder, mazeFactory);

        mazeGame.startGame(maze);

        System.out.println();
        mazeGame.checkSingleton();
    }
}



