import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends JPanel {
    private Cell[][] cells = new Cell[10][10];
    private List<Ship> ships = new ArrayList<>();

    public GameBoard() {
        this.setLayout(new GridLayout(10, 10));
        initializeBoard();
        placeShips();
    }

    private void initializeBoard() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                cells[row][col] = new Cell(row, col);
                this.add(cells[row][col]);
            }
        }
    }

    private void placeShips() {
        // Random placement logic (to implement)
    }

    public boolean allShipsSunk() {
        for (Ship s : ships) {
            if (!s.isSunk()) return false;
        }
        return true;
    }
}
