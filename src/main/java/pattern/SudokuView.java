package pattern;

import java.util.Scanner;

public class SudokuView {

    private SudokuModel model;
    private SudokuCellView[][] cells;

    public SudokuView(SudokuModel model) {
        this.model = model;
        this.cells = new SudokuCellView[model.getBoardSize()][model.getBoardSize()];
        for (int i = 0; i < model.getBoardSize(); i++) {
            for (int j = 0; j < model.getBoardSize(); j++) {
                cells[i][j] = new SudokuCellView(i, j, model.getValueAt(i, j));
            }
        }
    }

    public void display() {
        for (int row = 0; row < model.getBoardSize(); row++) {
            if (row % model.getBlockSize() == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < model.getBoardSize(); col++) {
                if (col % model.getBlockSize() == 0) {
                    System.out.print("| ");
                }
                cells[row][col].display();
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

    //TODO : displayOld() is not used anymore, remove it?

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Sudoku game!");
        System.out.println("Please enter the board size:");
    }

    /*
    Cette méthode utilise un objet Scanner pour lire les entrées de l'utilisateur à partir de la console.
    Elle demande d'abord le numéro de ligne et ensuite le numéro de colonne, en soustrayant 1 de chaque
    numéro pour convertir l'indexage en 0-based. Elle renvoie un tableau d'entiers contenant les coordonnées
    saisies par l'utilisateur.
     */

    public int[] askUserForCoords() {
        Scanner scanner = new Scanner(System.in);
        int[] coords = new int[2];
        System.out.println("Enter row number (1-9):");
        coords[0] = scanner.nextInt() - 1; // Convert to 0-based indexing
        System.out.println("Enter column number (1-9):");
        coords[1] = scanner.nextInt() - 1; // Convert to 0-based indexing
        return coords;
    }

    /*
    Cette méthode affiche un message demandant à l'utilisateur d'entrer une valeur entre 1 et 9, puis lit l'entrée
    utilisateur à partir de la console à l'aide de la classe Scanner. Elle renvoie la valeur saisie sous forme d'un entier.
     */
    public int askUserForValue() {
        System.out.print("Enter value (1-9): ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        return value;
    }

    public void displayVictoryMessage() {
        System.out.println("Congratulations, you won the game!");
    }

}
