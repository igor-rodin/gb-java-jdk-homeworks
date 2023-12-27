package monty_hall;

import java.util.HashMap;
import java.util.Map;

public class App {
    private static final int GAMES_COUNT = 1000;

    private void testGame(Game.PlayerStrategy playerStrategy) {
        Map<Integer, Boolean> stat = new HashMap<>();
        Game game = new Game(playerStrategy);
        for (int i = 0; i < GAMES_COUNT; i++) {
            boolean result = game.playAndGetResult();
            stat.put(i, result);
        }
        showStat(stat, playerStrategy);
    }

    private void showStat(Map<Integer, Boolean> stat, Game.PlayerStrategy playerStrategy) {
        int winCount = 0;
        int loseCount = 0;

        for (Map.Entry<Integer, Boolean> entry : stat.entrySet()) {
            if (entry.getValue()) {
                winCount++;
            } else {
                loseCount++;
            }
        }

        System.out.println("Strategy: " + playerStrategy);
        System.out.println("Win: " + winCount + " Lose: " + loseCount);
        System.out.println("Win percentage: " + 100 * (double) winCount / GAMES_COUNT + "%");
        System.out.println("Loose percentage: " + 100 * (double) loseCount / GAMES_COUNT + "%");
    }

    public static void main(String[] args) {
        var app = new App();
        System.out.println("----------Игрок оставляет выбор двери-----------------------");
        app.testGame(Game.PlayerStrategy.STAY);
        System.out.println("----------Игрок меняет выбор двери -------------------------");
        app.testGame(Game.PlayerStrategy.CHANGE);
    }
}
