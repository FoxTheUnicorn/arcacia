package arcacia.game.scene.panel;

import arcacia.game.handler.InputHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.scene.SceneHandler;
import arcacia.game.scene.other.HomeButton;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

public class LevelPanel extends JPanel {
    private final LevelCanvas canvas = new LevelCanvas();
    private final JLabel scoreLabel = new JLabel();

    public LevelPanel() {
        setFocusable(false);
        setPreferredSize(new Dimension(1000,500));

        JButton redrawButton = new JButton("Redraw");
        redrawButton.addActionListener((e) -> SceneHandler.drawGrid());
        add(redrawButton);

        setScore(0);
        add(scoreLabel);



        JButton testButton = new JButton("Toggle Key");
        testButton.addActionListener((e) -> PlayerHandler.setHasKey(!PlayerHandler.hasKey()));
        add(testButton);

        HomeButton homeButton = new HomeButton();
        homeButton.setLocation(0,0);
        add(homeButton);

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
