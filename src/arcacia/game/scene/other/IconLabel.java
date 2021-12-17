package arcacia.game.scene.other;

import arcacia.game.objects.item.CoinItem;

import javax.swing.*;

public class IconLabel extends JLabel {

    public IconLabel(String text, String iconPath) {
        setText(text);
        setIcon(new ImageIcon(iconPath));
    }

}
