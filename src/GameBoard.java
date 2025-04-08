import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends JPanel {
    private Cell[][] cells = new Cell[10][10];
    private List<Ship> ships = new ArrayList<>();
    private GameController controller;

    public GameBoard(GameController controller) {
        this.controller = controller;
        this.setLayout(new GridLayout(10, 10));
        initializeBoard();
        placeShips(); // You will write this
    }

    private void initializeBoard() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Cell cell = new Cell(row, col, controller);
                cells[row][col] = cell;
                this.add(cell);
            }
        }
    }

    public void resetBoard() {
        this.removeAll();
        ships.clear();
        initializeBoard();
        placeShips();
        this.revalidate();
        this.repaint();
    }

    private void placeShips() {
        int[] shipSizes = {5, 4, 3, 3, 2};
        for (int size : shipSizes) {
            boolean placed = false;

            while (!placed) {
                boolean horizontal = Math.random() < 0.5;
                int row = (int) (Math.random() * (horizontal ? 10 : 10 - size + 1));
                int col = (int) (Math.random() * (horizontal ? 10 - size + 1 : 10));

                if (canPlaceShip(row, col, size, horizontal)) {
                    Ship ship = new Ship(size);

                    for (int i = 0; i < size; i++) {
                        Cell cell = horizontal ? cells[row][col + i] : cells[row + i][col];
                        ship.addCell(cell); // sets ship ref in cell and adds to ship
                    }

                    ships.add(ship);
                    placed = true;
                }
            }
        }
    }

    private boolean canPlaceShip(int row, int col, int size, boolean horizontal) {
        for (int i = 0; i < size; i++) {
            int r = horizontal ? row : row + i;
            int c = horizontal ? col + i : col;

            if (cells[r][c].hasShip()) {
                return false;
            }
        }
        return true;
    }

    public boolean allShipsSunk() {
        for (Ship s : ships) {
            if (!s.isSunk()) return false;
        }
        return true;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
}
