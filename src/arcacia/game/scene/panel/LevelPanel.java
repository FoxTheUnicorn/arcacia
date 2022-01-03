package arcacia.game.scene.panel;

import arcacia.game.handler.GameHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.objects.item.ExtraLife;
import arcacia.game.scene.other.IconLabel;
import arcacia.game.scene.other.MenuButton;

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
        add(new MenuButton("Toggle key", (e) -> PlayerHandler.setHasKey(true), Component.RIGHT_ALIGNMENT));
        add(new MenuButton("Go to Highscore", (e) -> GameHandler.setLevel_number(4), Component.RIGHT_ALIGNMENT));
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
