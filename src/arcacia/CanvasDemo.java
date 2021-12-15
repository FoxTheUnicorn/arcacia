package arcacia;

import arcacia.game.handler.LevelHandler;
import arcacia.game.scene.TutorialFrame;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Color.black;

public class CanvasDemo extends JFrame {
    MyCanvas myCanvas = new MyCanvas(0);
    public static void main(String[] args){
        CanvasDemo canvasDemo = new CanvasDemo();
    }
    public CanvasDemo() {
        setTitle("Probe");
        setSize(750,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(myCanvas);
        setVisible(true);
        //SEEE ALL OF THE CANVAS
        pack();
    }
}
