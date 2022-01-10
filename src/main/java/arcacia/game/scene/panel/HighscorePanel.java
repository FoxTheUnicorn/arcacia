package arcacia.game.scene.panel;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.scene.other.HomeButton;
import arcacia.game.handler.HighscoreHandler;
import arcacia.game.util.Score;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HighscorePanel extends AbstractMenu {
    public HighscorePanel() {
        HomeButton hb = new HomeButton();
        hb.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(hb);
        initTable();
    }


    private void initTable() {
        JLabel highScoreLabel = new JLabel();
        ImageIcon highScoreIcon = new ImageIcon(ConstantHandler.pathImages + "highscore_small.png");
        highScoreLabel.setSize(250,100);
        highScoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScoreLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        highScoreLabel.setIcon(highScoreIcon);
        add(highScoreLabel);

        List<Score> highscoreList = HighscoreHandler.getScoreList();

        int size = highscoreList.size();
        String[][] list = new String[10][3];
        for (int i = 0; i<size;i++){
            list[i][0] = "" + (i+1);
            list[i][1] = highscoreList.get(i).getName();
            list[i][2] = "" + highscoreList.get(i).getPoints();
        }

        String[] header = { "Rank", "Player", "Score"};
        JTable table = new JTable(list, header);
        table.setRowHeight(21);
        table.setPreferredSize(new Dimension(500, 210));
        table.setDefaultEditor(Object.class, null);
        add(table);
    }
}







