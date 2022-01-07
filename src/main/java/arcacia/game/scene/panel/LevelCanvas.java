package arcacia.game.scene.panel;

import arcacia.game.handler.InputHandler;
import arcacia.game.handler.LevelHandler;
import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class LevelCanvas extends JPanel {

    //TODO Spieler verschwindet beim einsammeln von Münzen

        public LevelCanvas() {
            setFocusable(true);
            setBackground(Color.black);
            setPreferredSize(new Dimension(LevelHandler.level_width*32, LevelHandler.level_height*32));
            addKeyListener(new InputHandler());
            requestFocus();
        }

        public void initialDraw() {

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(int x = 0; x < LevelHandler.level_width; x++) {
                for(int y = 0; y < LevelHandler.level_height; y++) {
                    GameObject obj = LevelHandler.getObjectAt(new Location(x,y));
                    if(obj == null) continue;
                    g.drawImage(obj.getImage(), x*32, y*32, null);
                }
            }
        }

        public void drawGrid() {
            repaint();
        }

    }
