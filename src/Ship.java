import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int size;
    private List<Cell> cells = new ArrayList<>();

    public Ship(int size) {
        this.size = size;
    }

    public void addCell(Cell cell) {
        cells.add(cell);
        cell.setShip(this);
    }

    public boolean isSunk() {
        for (Cell c : cells) {
            if (!c.isClicked()) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }
}
