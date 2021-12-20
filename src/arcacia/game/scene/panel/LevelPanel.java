package arcacia.game.scene.panel;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.handler.InputHandler;
import arcacia.game.handler.LevelHandler;
import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class LevelPanel extends Canvas{

        public Graphics g;
        public BufferedImage image;

        public LevelPanel() {
            setBackground(Color.black);
            setPreferredSize(new Dimension(LevelHandler.));
        }

        public void draw(BufferedImage image, int x, int y) {
            getGraphics().drawImage(image, x, y, null);
        }

        public void drawGrid() {
            for(int x = 0; x < LevelHandler.level_width; x++) {
                for(int y = 0; y < LevelHandler.level_height; y++) {
                    GameObject obj = LevelHandler.getObjectAt(new Location(x,y));
                    draw(obj.getImage(),x*32, y*32);
                }
            }
        }

    }
