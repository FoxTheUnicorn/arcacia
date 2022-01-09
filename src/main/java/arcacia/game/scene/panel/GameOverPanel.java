package arcacia.game.scene.panel;

import arcacia.game.handler.FileHandler;
import arcacia.game.handler.GameHandler;
import arcacia.game.scene.SceneHandler;
import arcacia.game.scene.other.MenuButton;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends AbstractMenu {

    public GameOverPanel() {
        super();
        addSpacer(20);

        //TODO Replace with Icon
        JLabel title = new JLabel();
        title.setText("Game Over");
        title.setFont(new Font("Sans-Serif", Font.PLAIN, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBackground(Color.white);
        title.setOpaque(true);
        add(title);

        addSpacer(15);

        add(new MenuButton("Restart", e -> {GameHandler.startNewGame(); SceneHandler.showLevel();}, Component.CENTER_ALIGNMENT));
        addSpacer(15);

        //add(new MenuButton("Next Level", e -> {}, Component.CENTER_ALIGNMENT));
        //addSpacer(15);

        add(new MenuButton("Main Menu", e -> SceneHandler.showMainMenu(), Component.CENTER_ALIGNMENT));
        addSpacer(15);
    }
}

