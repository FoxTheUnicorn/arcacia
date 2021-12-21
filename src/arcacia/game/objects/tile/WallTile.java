package arcacia.game.objects.tile;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WallTile extends GameObject {
    public static final String path = ConstantHandler.pathImages + "WalLTile.png";
    public WallTile(Location currentLocation) {
        super(currentLocation);
    }

    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public WallTile(int x, int y) {
        super(new Location(x, y));
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
