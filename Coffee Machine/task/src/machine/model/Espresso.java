package machine.model;

public class Espresso extends CoffeeCup {
    public Espresso() {
        super();
    }

    @Override
    public int getWater() {
        return 250;
    }

    @Override
    public int getMilk() {
        return 0;
    }

    @Override
    public int getCoffee() {
        return 16;
    }

    @Override
    public int getPrice() {
        return 4;
    }
}
