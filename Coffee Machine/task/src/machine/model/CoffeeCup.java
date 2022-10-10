package machine.model;

public abstract class CoffeeCup {
    private int water;
    private int milk;
    private int coffee;
    private int price;

    public CoffeeCup() {
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getPrice() {
        return price;
    }
}
