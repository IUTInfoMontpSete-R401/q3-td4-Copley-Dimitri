package pattern;

public class SudokuCellView implements SudokuObserver, ViewComponent {
    private int row;
    private int col;
    private int value;

    public SudokuCellView(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    @Override
    public void update(int row, int col, int value) {
        if (row == this.row && col == this.col) {
            this.value = value;
        }
    }

    @Override
    public void display() {
        System.out.println(value);
    }
}
