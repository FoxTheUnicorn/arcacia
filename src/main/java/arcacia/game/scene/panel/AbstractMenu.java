package arcacia.game.scene.panel;

import arcacia.game.handler.ConstantHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class AbstractMenu extends JPanel {
    private static Image background = null;

    public AbstractMenu() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        try {
            background = ImageIO.read(new File(ConstantHandler.pathImages + "Acacia.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(background != null) {
            setPreferredSize(new Dimension(background.getWidth(null), background.getHeight(null)));
        }
    }

    protected void addSpacer(int height) {
        add(Box.createVerticalStrut(height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(background != null) {
            Image scaledBackground = background.getScaledInstance(getSize().width*ConstantHandler.menuScale,
                    getSize().height*ConstantHandler.menuScale,
                    Image.SCALE_FAST);
            g.drawImage(scaledBackground, 0, 0, null);
        }
    }
}
