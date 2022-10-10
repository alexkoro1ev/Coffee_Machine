package machine;

import machine.model.*;

public class Controller {

    private final Machine machine = Machine.getInstance(400, 540, 120, 9, 550);
    private final View view;
    private boolean isFinished = false;


    public Controller(View view) {
        this.view = view;
    }

    public void chooseAction() {
        Console.writeLine("Write action (buy, fill, take, remaining, exit):");
        String action = Console.readLine();

        switch (action) {
            case "buy":
                CoffeeCup coffeeCup = chooseCoffee();
                if (coffeeCup == null) {
                    break;
                }
                if (checkResourcesAvailability(coffeeCup)) {
                    machine.sellCoffee(coffeeCup);
                } else {
                    Console.writeLine(String.format("Sorry, not enough %s!",
                            notEnoughResourceMessage(coffeeCup)));
                }
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                withdrawCash();
                break;
            case "remaining":
                Console.writeLine(machine.toString());
                break;
            case "exit":
                isFinished = true;
        }
    }

    private boolean checkResourcesAvailability(CoffeeCup cup) {
        boolean checkWater = machine.getWater() >= cup.getWater();
        boolean checkMilk = machine.getMilk() >= cup.getMilk();
        boolean checkCoffee = machine.getCoffee() >= cup.getCoffee();
        boolean checkCups = machine.getCups() > 0;

        return checkWater && checkMilk && checkCoffee && checkCups;
    }

    private String notEnoughResourceMessage(CoffeeCup cup) {
        if (machine.getWater() < cup.getWater()) {
            return "water";
        } else if (machine.getMilk() < cup.getMilk()) {
            return "milk";
        } else if (machine.getCoffee() < cup.getCoffee()) {
            return "coffee beans";
        } else {
            return "disposable cups";
        }
    }

    private CoffeeCup chooseCoffee() {
        String choice;
        Console.writeLine("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: :");
        choice = Console.readLine();

        switch (choice) {
            case "1":
                return new Espresso();
            case "2":
                return new Latte();
            case "3":
                return new Cappuccino();
            case "back":
                return null;
        }

        return null;
    }

    private void fillMachine() {
        Console.writeLine("Write how many ml of water you want to add:");
        int water = Console.readInt();
        Console.writeLine("Write how many ml of milk you want to add:");
        int milk = Console.readInt();
        Console.writeLine("Write how many grams of coffee beans you want to add:");
        int coffee = Console.readInt();
        Console.writeLine("Write how many disposable cups you want to add:");
        int cups = Console.readInt();

        machine.fill(water, milk, coffee, cups);
    }

    private void withdrawCash() {
        int withdrawn = machine.withdraw();
        Console.writeLine(String.format("I gave you $%d", withdrawn));
    }

    public void requireIngredientsAmount() {
        Console.writeLine("Write how many ml of water the coffee machine has:");
        int waterAmount = Console.readInt();
        Console.writeLine("Write how many ml of milk the coffee machine has:");
        int milkAmount = Console.readInt();
        Console.writeLine("Write how many grams of coffee beans the coffee machine has:");
        int coffeeAmount = Console.readInt();
        Console.writeLine("Write how many cups of coffee you will need: ");
        int cupsAmount = Console.readInt();

        Console.writeLine(getCupsAvailable(waterAmount, milkAmount, coffeeAmount, cupsAmount));
    }

    private String getCupsAvailable(int water, int milk, int coffee, int cups) {
        int cupsAvailable = Math.min(Math.min(water / calculateWater(new Cappuccino(), 1), milk / calculateMilk(new Cappuccino(), 1)),
                coffee / calculateCoffee(new Cappuccino(), 1));

        if (cupsAvailable < cups) {
            return String.format("No, I can make only %d cup(s) of coffee", cupsAvailable);
        } else if (cupsAvailable > cups) {
            return String.format("Yes, I can make that amount of coffee (and even %d more than that)", cupsAvailable - cups);
        }

        return "Yes, I can make that amount of coffee";
    }

    private int calculateWater(CoffeeCup coffeeCup, int cupsAmount) {
        return cupsAmount * coffeeCup.getWater();
    }

    private int calculateMilk(CoffeeCup coffeeCup, int cupsAmount) {
        return cupsAmount * coffeeCup.getMilk();
    }

    private int calculateCoffee(CoffeeCup coffeeCup, int cupsAmount) {
        return cupsAmount * coffeeCup.getCoffee();
    }

    private int calculatePrice(CoffeeCup coffeeCup, int cupsAmount) {
        return cupsAmount * coffeeCup.getPrice();
    }

    public boolean isFinished() {
        return isFinished;
    }
}
