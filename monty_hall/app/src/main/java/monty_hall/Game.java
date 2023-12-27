package monty_hall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    private static Random random = new Random();
    private final static int DOORS_COUNT = 3;
    private final int prizeDoorId;
    private final List<Door> doors = new ArrayList<>();
    private PlayerStrategy playerStrategy;

    enum PlayerStrategy {
        STAY,
        CHANGE
    }

    public Game(PlayerStrategy playerStrategy) {
        this.playerStrategy = playerStrategy;
        prizeDoorId = random.nextInt(1, DOORS_COUNT + 1);
        for (int i = 0; i < DOORS_COUNT; i++) {
            doors.add(new Door(i + 1, i + 1 == prizeDoorId));
        }
        Collections.shuffle(doors);
    }

    public Game() {
        this(PlayerStrategy.STAY);
    }

    public int playerChoice() {
        return random.nextInt(1, DOORS_COUNT + 1);

    }

    public int hostChoice(int playerChoiceDoorId) {
        if (playerChoiceDoorId == prizeDoorId) {
            List<Integer> hostIds = doors.stream()
                    .filter(d -> !(d.getId() == prizeDoorId))
                    .map(d -> d.getId())
                    .toList();
            return hostIds.get(random.nextInt(hostIds.size()));
        }
        return doors.stream()
                .filter(d -> !d.hasPrize() && !(d.getId() == playerChoiceDoorId))
                .findAny().get().getId();
    }

    public boolean playAndGetResult() {
        int playerChoiceDoorId = playerChoice();
        int hostChoiceDoorId = hostChoice(playerChoiceDoorId);
        int finalChiceDoorId = getFinalChoice(playerChoiceDoorId, hostChoiceDoorId);
        return finalChiceDoorId == prizeDoorId;
    }

    private int getFinalChoice(int playerChoiceDoorId, int hostChoiceDoorId) {
        if (playerStrategy == PlayerStrategy.STAY) {
            return playerChoiceDoorId;
        } else {
            return doors.stream().filter(d -> d.getId() != playerChoiceDoorId && d.getId() != hostChoiceDoorId)
                    .findAny().get().getId();
        }
    }
}
