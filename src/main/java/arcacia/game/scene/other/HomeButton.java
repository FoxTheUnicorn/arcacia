package arcacia.game.scene.other;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.scene.SceneHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HomeButton extends JButton {

    public HomeButton() {
        Image homeIcon = null;
        try {
            homeIcon = ImageIO.read(new File(ConstantHandler.pathImages + "home.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(homeIcon != null) {
            setIcon(new ImageIcon(homeIcon));
        }
        setSize(new Dimension(64,64));
        setContentAreaFilled(false);
        setBorder(null);
        addActionListener(e -> SceneHandler.goBack());
        setFocusPainted(false);
    }
}
