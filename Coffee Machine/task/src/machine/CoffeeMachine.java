package machine;

public class CoffeeMachine {
    private final View view;
    private final Controller controller;

    public CoffeeMachine() {
        this.view = new View();
        this.controller = new Controller(view);
    }

    public void run() {
        while (!controller.isFinished()) {
            controller.chooseAction();
        }
    }
}
