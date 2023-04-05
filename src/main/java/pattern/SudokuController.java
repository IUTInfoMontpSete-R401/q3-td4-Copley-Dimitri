package pattern;

import java.util.Stack;

public class SudokuController {
    private Stack<Command> commands = new Stack<>();
    private SudokuModel model;
    private SudokuView view;
    private Solver solver;

    public SudokuController(SudokuModel model, SudokuView view, Solver solver) {
        this.model = model;
        this.view = view;
        this.solver = solver;
    }


}
