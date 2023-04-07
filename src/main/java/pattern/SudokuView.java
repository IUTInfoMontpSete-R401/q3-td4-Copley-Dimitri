package pattern;

import java.util.Scanner;

public class SudokuView {

    private SudokuModel model;
    private ViewComponent[] children;


    public SudokuView(SudokuModel model) {
        this.model = model;
        children = new ViewComponent[model.getBoardSize()];
        for (int row = 0; row < model.getBoardSize(); row++) {
            LineView line = new LineView(model.getBoardSize());
            for (int col = 0; col < model.getBoardSize(); col++) {
                line.setChild(col, new SudokuCellView(row, col, model));
            }
            children[row] = line;
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
                children[row].getChildren()[col].display();
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }


    public int askOption() {
        System.out.println("1. Set value");
        System.out.println("2. Undo");
        System.out.println("3. Solve");
        System.out.println("4. Exit");
        System.out.println("Please enter your option:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Sudoku game!");
        System.out.println("Please enter the board size:");
    }

    public SetValueCommand askInput() {
        return new SetValueCommand(askUserForCoords(), askUserForValue(), model);
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
