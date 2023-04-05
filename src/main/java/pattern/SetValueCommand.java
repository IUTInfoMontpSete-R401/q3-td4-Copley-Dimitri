package pattern;

public class SetValueCommand implements Command{
    private int row;
    private int col;
    private int value;
    private SudokuModel model;

    public SetValueCommand(int row, int col, int value, SudokuModel model) {
        this.row = row;
        this.col = col;
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
