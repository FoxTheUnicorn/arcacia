package arcacia.game.scene.panel;

import arcacia.game.handler.LevelHandler;
import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelCanvas extends Canvas{

        public LevelCanvas() {
            setBackground(Color.black);
            setPreferredSize(new Dimension(LevelHandler.level_width*32, LevelHandler.level_height*32));
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
