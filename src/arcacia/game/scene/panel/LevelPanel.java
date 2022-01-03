package arcacia.game.scene.panel;

import arcacia.game.objects.item.ExtraLife;
import arcacia.game.scene.other.IconLabel;

import javax.swing.*;
import java.awt.*;

public class LevelPanel extends JPanel {
    private final LevelCanvas canvas = new LevelCanvas();
    private final JLabel scoreLabel = new JLabel();
    private final JLabel lives = new IconLabel("Leben: 3", ExtraLife.path);

    public LevelPanel() {
        setFocusable(false);
        setPreferredSize(new Dimension(1000,500));

        setScore(0);

        add(scoreLabel);
        add(lives);
        add(canvas);
    }

    public void setScore(int x) {
         scoreLabel.setText("Score: " + x);
    }

    public void setLives(int x) {
         lives.setText("Leben: " + x);
    }

    public void updateFocus() {
        canvas.requestFocus();
    }

    public void drawGrid() {
        canvas.drawGrid();
    }
}
