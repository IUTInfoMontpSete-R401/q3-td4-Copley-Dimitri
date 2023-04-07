package pattern;

public class App {
    public static void main(String[] args) throws InterruptedException {
        SudokuModel model = new SudokuModel(9);
        SudokuView view = new SudokuView(model);
        Solver solver = new BackTrackingSolver();
        SudokuController controller = new SudokuController(model, view, solver);
        controller.startGame();
    }
}
