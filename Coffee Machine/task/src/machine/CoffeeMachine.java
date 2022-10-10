package machine;

public class CoffeeMachine {
    private final Controller controller;

    public CoffeeMachine() {
        this.controller = new Controller();
    }

    public void run() {
        while (!controller.isFinished()) {
            controller.chooseAction();
        }
    }
}
