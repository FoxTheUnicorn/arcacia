package arcacia.game.scene;
import arcacia.CanvasDemo;
import arcacia.game.handler.ConstantHandler;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Arcacia a Game by SWE-Team_B3");
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void update() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
