import javax.swing.*;

public class MainGUI extends JFrame {
    private GameBoard gameBoard;
    private StatusPanel statusPanel;
    private GameController controller;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().initUI());
    }

    public void initUI() {
        this.setTitle("Battleship");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 900);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        controller = new GameController();
        statusPanel = new StatusPanel();
        gameBoard = new GameBoard(controller);
        controller.setBoard(gameBoard);
        controller.setStatusPanel(statusPanel);

        this.add(gameBoard);
        this.add(statusPanel);
        this.setVisible(true);
    }
}
