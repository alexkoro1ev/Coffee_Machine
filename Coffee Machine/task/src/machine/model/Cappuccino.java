package machine.model;

public class Cappuccino extends CoffeeCup {
    @Override
    public int getWater() {
        return 200;
    }

    @Override
    public int getMilk() {
        return 100;
    }

    @Override
    public int getCoffee() {
        return 12;
    }

    @Override
    public int getPrice() {
        return 6;
    }
}
