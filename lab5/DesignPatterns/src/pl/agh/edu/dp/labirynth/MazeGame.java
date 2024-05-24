package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.builder.MazeDirector;
import pl.agh.edu.dp.labirynth.factory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.factory.NormalMazeFactory;
import pl.agh.edu.dp.labirynth.maze.Maze;
import pl.agh.edu.dp.labirynth.model.MapSite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class MazeGame {
    public Maze createRandomizedMaze(MazeBuilder builder, MazeFactory mazeFactory) {
        MazeDirector director = new MazeDirector();
        return director.createRandomizedMaze();
    }

    public void checkSingleton() {
        MazeFactory mazeFactory = NormalMazeFactory.getInstance();
        System.out.println("Normal factory is singleton: " + mazeFactory.equals(NormalMazeFactory.getInstance()));

        mazeFactory = BombedMazeFactory.getInstance();
        System.out.println("Bombed factory is singleton: " + mazeFactory.equals(BombedMazeFactory.getInstance()));

        mazeFactory = EnchantedMazeFactory.getInstance();
        System.out.println("Enchanted factory is singleton: " + mazeFactory.equals(EnchantedMazeFactory.getInstance()));

    }

    public void startGame(Maze maze) {
        System.out.println("""
                Commands:
                - q - exit
                - a - move West
                - s - move South
                - d - move East
                - w - move North
                """);
        Player player = new Player(maze.getStartRoom());
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            while (true) {

                System.out.println();
                Future<String> future = executor.submit(new InputReaderTask());
                String input = null;
                try {
                    input = future.get(10, TimeUnit.SECONDS);
                } catch (TimeoutException e) {
                    System.out.println("Timeout: No input received within 10 seconds, player's damaged -5LP");
                    player.decreaseLife(5);
                    future.cancel(true); // Cancel the task if it's still running
                }
                System.out.println();
                if (input != null) {
                    if (input.equals("q")) return;
                    MapSite mapSite = switch (input) {
                        case "w" -> {
                            System.out.println("Moving North");
                            yield player.getCurrentRoom().getSide(Direction.North);
                        }
                        case "s" -> {
                            System.out.println("Moving South");
                            yield player.getCurrentRoom().getSide(Direction.South);
                        }
                        case "a" -> {
                            System.out.println("Moving West");
                            yield player.getCurrentRoom().getSide(Direction.West);
                        }
                        case "d" -> {
                            System.out.println("Moving East");
                            yield player.getCurrentRoom().getSide(Direction.East);
                        }
                        default -> {
                            System.out.println("No such option!");
                            yield null;
                        }

                    };
                    if (mapSite == null) {
                        System.out.println("Nothing there!");
                    } else {
                        mapSite.Enter(player);
                    }
                }
                if (player.isDead()) {
                    System.out.println("Your life points are 0, you lose");
                    break;
                }
                if (player.getPoints() >= 10) {
                    System.out.println("You win!");
                    break;
                }
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
    }

    static class InputReaderTask implements Callable<String> {
        @Override
        public String call() throws IOException {
            var reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        }
    }


}
