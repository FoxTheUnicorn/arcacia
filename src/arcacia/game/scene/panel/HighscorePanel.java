package arcacia.game.scene.panel;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.objects.GameObject;
import arcacia.game.objects.item.CoinItem;
import arcacia.game.objects.tile.WallTile;
import arcacia.game.scene.other.HomeButton;
import arcacia.game.util.Location;

import javax.swing.*;
import java.awt.*;

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

        String[][] rec = {
                { "1", "Elliot", "100"},
                { "2", "Lucas", "99"},
                { "3", "Mert", "98"},
                { "4", "Alina", "97"},
                { "5", "Byungjun", "96"},
        };


        //TODO Change to use Highscore.class
        String[] header = { "Rank", "Player", "Score"};
        JTable table = new JTable(rec, header);
        table.setRowHeight(20);
        table.setPreferredSize(new Dimension(500, 200));
        table.setDefaultEditor(Object.class, null);
        add(table);
    }
}







