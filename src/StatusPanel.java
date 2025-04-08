import javax.swing.*;

public class StatusPanel extends JPanel {
    private JLabel missLabel, strikeLabel, totalMissLabel, totalHitLabel;
    private JButton quitButton, playAgainButton;

    public StatusPanel() {
        missLabel = new JLabel("Miss: 0");
        strikeLabel = new JLabel("Strikes: 0");
        totalMissLabel = new JLabel("Total Misses: 0");
        totalHitLabel = new JLabel("Total Hits: 0");

        quitButton = new JButton("Quit");
        playAgainButton = new JButton("Play Again");

        this.add(missLabel);
        this.add(strikeLabel);
        this.add(totalMissLabel);
        this.add(totalHitLabel);
        this.add(playAgainButton);
        this.add(quitButton);
    }

    public void updateDisplay(int miss, int strikes, int totalMiss, int totalHit) {
        missLabel.setText("Miss: " + miss);
        strikeLabel.setText("Strikes: " + strikes);
        totalMissLabel.setText("Total Misses: " + totalMiss);
        totalHitLabel.setText("Total Hits: " + totalHit);
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public JButton getPlayAgainButton() {
        return playAgainButton;
    }
}
