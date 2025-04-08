import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private int row, col;
    private boolean isClicked = false;
    private Ship ship;

    private static Icon loadScaledIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    private static final Icon WAVE_ICON = loadScaledIcon("images/wave.png", 60, 60);
    private static final Icon SPLASH_ICON = loadScaledIcon("images/splash.png", 60, 60);
    private static final Icon EXPLOSION_ICON = loadScaledIcon("images/explosion.png", 60, 60);


    public Cell(int row, int col, GameController controller) {
        this.row = row;
        this.col = col;
        this.setIcon(WAVE_ICON);
        this.addActionListener(e -> controller.handleClick(this));
    }

    public void setHit() {
        isClicked = true;
        this.setIcon(EXPLOSION_ICON);
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        this.setEnabled(false);
    }

    public void setMiss() {
        isClicked = true;
        this.setIcon(SPLASH_ICON);
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
        this.setEnabled(false);
    }

    public boolean isClicked() {
        return isClicked;
    }

    public boolean hasShip() {
        return ship != null;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
