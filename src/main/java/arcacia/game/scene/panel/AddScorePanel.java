package arcacia.game.scene.panel;

import arcacia.game.handler.PlayerHandler;
import arcacia.game.scene.SceneHandler;
import arcacia.game.handler.HighscoreHandler;
import arcacia.game.util.Score;

import javax.swing.*;
import java.awt.*;

public class AddScorePanel extends JPanel {
    public AddScorePanel()
    {
        setLayout(null);
        initAddScore();
        setPreferredSize(new Dimension(500, 250));
    }

    public void initAddScore()
    {
        JLabel header = new JLabel("Bitte geben Sie Ihren Namen ein.");
        JTextField name = new JTextField();
        JButton submit = new JButton("eingeben");
        submit.addActionListener((e) -> {
            int scoreWithHearts = PlayerHandler.getScore() + (PlayerHandler.getLives()*10);
            Score score = new Score(name.getText(), scoreWithHearts);
            HighscoreHandler.addScore(score);
            SceneHandler.showHighscore();
        });

        header.setBounds(100, 20, 250, 50);
        name.setBounds(100, 80, 150, 30);
        submit.setBounds(30, 150, 150, 30);

        add(header);
        add(name);
        add(submit);
    }
}
