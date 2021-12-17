package arcacia;

import javax.swing.*;

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
