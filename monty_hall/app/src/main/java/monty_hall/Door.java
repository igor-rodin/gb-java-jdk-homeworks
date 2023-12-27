package monty_hall;

public class Door {
    private int id;
    private boolean hasPrize;

    public Door(int id, boolean hasPrize) {
        this.id = id;
        this.hasPrize = hasPrize;
    }

    public int getId() {
        return id;
    }

    public boolean hasPrize() {
        return hasPrize;
    }

}
