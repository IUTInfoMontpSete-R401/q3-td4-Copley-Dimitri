package pattern;

public class BackTrackingSolver implements Solver {
    private SudokuController controller;

    public boolean solve(SudokuModel sudoku, SudokuController controller) {
        this.controller = controller;
        return solveCell(0, 0, sudoku);
    }

    private boolean solveCell(int row, int column, SudokuModel sudoku) {
        // Si on a parcouru toutes les cellules, la grille est résolue
        if (row == sudoku.getBoardSize()) {
            return true;
        }

        // Calcul de la prochaine cellule à traiter
        int nextRow = column == sudoku.getBoardSize() - 1 ? row + 1 : row;
        int nextColumn = (column + 1) % sudoku.getBoardSize();

        // Si la cellule actuelle est déjà remplie, passer à la suivante
        if (sudoku.getValueAt(row, column) != 0) {
            return solveCell(nextRow, nextColumn, sudoku);
        }

        // Essayer toutes les valeurs possibles pour la cellule actuelle
        for (int value = 1; value <= sudoku.getBoardSize(); value++) {
            if (sudoku.isValueValid(row, column, value)) {
                // Assigner la valeur à la cellule
                Command command = new SetValueCommand(new int[]{row, column}, value, sudoku);
                controller.handleUserInput(command);

                // Récursivement résoudre la grille à partir de la cellule suivante
                if (solveCell(nextRow, nextColumn, sudoku)) {
                    return true;
                }

                // Si la résolution a échoué, retirer la valeur de la cellule
                command.undo();
            }
        }

        // Si aucune valeur n'a fonctionné, revenir en arrière
        return false;
    }
}


