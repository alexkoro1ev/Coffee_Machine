package machine.model;

import machine.Console;

public class Machine {
    private static Machine instance;

    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int cash;

    private Machine(int water, int milk, int coffee, int cups, int cash) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.cash = cash;
    }

    public static Machine getInstance(int water, int milk, int coffee, int cups, int cash) {
        if (instance == null) {
            instance = new Machine(water, milk, coffee, cups, cash);
        }
        return instance;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return String.format("The coffee machine has:%n" +
                        "%d ml of water%n" +
                        "%d ml of milk%n" +
                        "%d g of coffee beans%n" +
                        "%d disposable cups%n" +
                        "$%d of money%n",
                water, milk, coffee, cups, cash);
    }

    public void sellCoffee(CoffeeCup cup) {
        water -= cup.getWater();
        milk -= cup.getMilk();
        coffee -= cup.getCoffee();
        cups--;
        cash += cup.getPrice();
        Console.writeLine("I have enough resources, making you a coffee!");
    }

    public void fill(int additionalWater, int additionalMilk, int additionalCoffee, int additionalCups) {
        water += additionalWater;
        milk += additionalMilk;
        coffee += additionalCoffee;
        cups += additionalCups;
    }

    public int withdraw() {
        int withdrawn = cash;
        cash = 0;
        return withdrawn;
    }
}
