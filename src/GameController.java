import javax.swing.*;

public class GameController {
    private GameBoard gameBoard;
    private StatusPanel statusPanel;

    private int missCounter = 0;
    private int strikeCounter = 0;
    private int totalMiss = 0;
    private int totalHit = 0;

    public void setBoard(GameBoard board) {
        this.gameBoard = board;
    }

    public void setStatusPanel(StatusPanel panel) {
        this.statusPanel = panel;

        panel.getQuitButton().addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "Quit the game?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        panel.getPlayAgainButton().addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "Start a new game?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                gameBoard.resetBoard(); //

            }
        });
    }

    public void handleClick(Cell cell) {
        if (cell.isClicked()) return;

        if (cell.hasShip()) {
            cell.setHit();
            totalHit++;
            missCounter = 0;

            if (cell.getShip().isSunk()) {
                JOptionPane.showMessageDialog(null, "You sunk a ship!");
            }

            if (gameBoard.allShipsSunk()) {
                int result = JOptionPane.showConfirmDialog(null, "You won! Play again?", "Victory!", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    gameBoard.resetBoard();
                    missCounter = 0;
                    strikeCounter = 0;
                    totalMiss = 0;
                    totalHit = 0;
                    statusPanel.updateDisplay(missCounter, strikeCounter, totalMiss, totalHit);
                }
            }
        } else {
            cell.setMiss();
            missCounter++;
            totalMiss++;

            if (missCounter >= 5) {
                strikeCounter++;
                missCounter = 0;
                if (strikeCounter >= 3) {
                    JOptionPane.showMessageDialog(null, "You lost!");
                    int result = JOptionPane.showConfirmDialog(null, "Play again?", "Game Over", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        gameBoard.resetBoard();
                        missCounter = 0;
                        strikeCounter = 0;
                        totalMiss = 0;
                        totalHit = 0;
                        statusPanel.updateDisplay(missCounter, strikeCounter, totalMiss, totalHit);
                    }
                }
            }
        }

        statusPanel.updateDisplay(missCounter, strikeCounter, totalMiss, totalHit);
    }

}
