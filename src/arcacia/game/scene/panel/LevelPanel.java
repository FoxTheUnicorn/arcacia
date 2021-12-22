package arcacia.game.scene.panel;

import javax.swing.*;
import java.awt.*;

public class LevelPanel extends JPanel {
    private final LevelCanvas canvas = new LevelCanvas();
    private final JLabel scoreLabel = new JLabel();

    public LevelPanel() {
        setFocusable(false);
        setPreferredSize(new Dimension(1000,500));

        setScore(0);

        add(scoreLabel);
        add(canvas);
    }

    public void setScore(int x) {
         scoreLabel.setText("Score: " + x);
    }

    public void updateFocus() {
        canvas.requestFocus();
    }

    public void drawGrid() {
        canvas.drawGrid();
    }
}
