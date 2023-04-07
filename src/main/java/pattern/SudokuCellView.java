package pattern;

public class SudokuCellView implements SudokuObserver, ViewComponent {
    private int row;
    private int col;
    private SudokuModel m;

    public SudokuCellView(int row, int col, SudokuModel m) {
        this.row = row;
        this.col = col;
        this.m = m;
        m.subscribe(this);
    }

    @Override
    public void update(int row, int col) {
        if (row == this.row && col == this.col) {
            System.out.println("Cell {" + row + "," + col + "} has been updated to " + m.getValueAt(row, col));
        }
    }

    @Override
    public void display() {
        if (m.getValueAt(row, col) == 0) {
            System.out.print("  ");
        } else {
            System.out.print(m.getValueAt(row, col) + " ");
        }
    }

    public ViewComponent[] getChildren() {
        return new ViewComponent[]{this};
    }
}
