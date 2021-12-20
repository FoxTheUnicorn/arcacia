package arcacia.game.scene.panel;

import arcacia.game.scene.SceneHandler;
import arcacia.game.scene.other.HomeButton;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

public class LevelPanel extends JPanel {
    private final LevelCanvas canvas = new LevelCanvas();

    public LevelPanel() {
        setPreferredSize(new Dimension(1000,500));

        JButton testButton = new JButton("Redraw");
        testButton.addActionListener((e) -> SceneHandler.drawGrid());
        add(testButton);

        HomeButton homeButton = new HomeButton();
        homeButton.setLocation(0,0);
        add(homeButton);

        add(canvas);
    }

    public void drawGrid() {
        canvas.drawGrid();
    }
}
