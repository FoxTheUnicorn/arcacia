package arcacia.game.scene.panel;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.objects.GameObject;
import arcacia.game.objects.item.CoinItem;
import arcacia.game.objects.tile.WallTile;
import arcacia.game.scene.other.HomeButton;
import arcacia.game.util.Highscore;
import arcacia.game.util.Location;
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

        //ab hier Lucas
        Highscore highscore = new Highscore("highScoreListe");
        List<Score> highscoreList = highscore.getScoreList();

        int size = highscoreList.size();
        String[][] rec = new String[10][3];
        for (int i = 0; i<size;i++){
            rec[(size-1)-i][0] = String.valueOf(size-i);
            rec[(size-1)-i][1] = highscoreList.get(i).getName();
            rec[(size-1)-i][2] = String.valueOf(highscoreList.get(i).getPoints());
        }

        //ende Lucas

        //TODO Change to use Highscore.class
        String[] header = { "Rank", "Player", "Score"};
        JTable table = new JTable(rec, header);
        table.setRowHeight(20);
        table.setPreferredSize(new Dimension(500, 200));
        table.setDefaultEditor(Object.class, null);
        add(table);
    }
}







