package machine.model;

public class Latte extends CoffeeCup {
    @Override
    public int getWater() {
        return 350;
    }

    @Override
    public int getMilk() {
        return 75;
    }

    @Override
    public int getCoffee() {
        return 20;
    }

    @Override
    public int getPrice() {
        return 7;
    }
}
