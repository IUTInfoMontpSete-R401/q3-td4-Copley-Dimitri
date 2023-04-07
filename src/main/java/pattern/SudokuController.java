package pattern;

import java.util.Stack;

public class SudokuController {
    private SudokuModel model;
    private SudokuView view;
    private Solver solver;

    Stack<Command> history = new Stack<>();

    public SudokuController(SudokuModel model, SudokuView view, Solver solver) {
        this.model = model;
        this.view = view;
        this.solver = solver;
    }

    //
    public void handleUserInput(Command command) {
        command.execute();
        history.push(command);
    }


    public void startGame() throws InterruptedException {
        view.displayWelcomeMessage();
        while (!model.isGameFinished()) {
            view.display();
            switch (view.askOption()) {
                case 1:
                    handleUserInput(view.askInput());
                    break;
                case 2:
                    if (!history.isEmpty()) {
                        Command last = history.pop();
                        last.undo();
                    }
                    break;
                case 3:
                    solver.solve(model, this);
                    view.display();
                    Thread.sleep(1000);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        view.displayVictoryMessage();
    }


}
