package pattern;

public class SetValueCommand implements Command {
    private int row;
    private int col;
    private int value;
    private SudokuModel model;

    public SetValueCommand(int[] coords, int value, SudokuModel model) {
        this.row = coords[0];
        this.col = coords[1];
        this.value = value;
        this.model = model;
    }

    public void execute() {
        model.setValueAt(row, col, value);
    }

    public void undo() {
        model.setValueAt(row, col, 0);
    }
}
