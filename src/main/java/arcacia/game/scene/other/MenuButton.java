package arcacia.game.scene.other;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuButton extends JButton {

    public MenuButton(String text, ActionListener al, float alignment) {
        setText(text);
        setBackground(Color.white);
        setSize(new Dimension(18,18));
        setMargin(new Insets(10,20,10, 20));
        setAlignmentX(alignment);
        addActionListener(al);
        setFocusPainted(false);
    }

}
