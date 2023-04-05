package pattern;

import java.util.List;
import java.util.Scanner;

public class SudokuView {

    private SudokuModel model;
    private List<ViewComponent> components;

    public SudokuView(SudokuModel model) {
        this.model = model;
    }

    public void display() {
        for (ViewComponent component : components) {
            component.display();
        }
    }
//TODO : displayOld() is not used anymore, remove it?
    public void displayOld() {
        for (int row = 0; row < model.getBoardSize(); row++) {
            if (row % model.getBlockSize() == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < model.getBoardSize(); col++) {
                if (col % model.getBlockSize() == 0) {
                    System.out.print("| ");
                }
                int value = model.getValueAt(row, col);
                if (value == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

    public void update(int row, int col, int value) {
        System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
        display();

    }

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
