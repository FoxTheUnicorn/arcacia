package arcacia;
//import arcacia.game.handler.InputHandler;

import arcacia.game.handler.InputHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Display {//PANEL
    public JFrame jframe;
    public static Canvas canvas;
    public String title;
    public int width, height;
    public Graphics g;
    public BufferedImage image;

    public Display(String title, int height, int width) {
        this.title = title;
        this.width = width;
        this.height = height;

        InputHandler listener = new InputHandler();

        jframe = new JFrame(title);

        jframe.addKeyListener(listener);

        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);

        /*try {
            image = loadImage("Coin");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        canvas = new Canvas();
        //canvas.setBackground(Color.decode("#FEF6A3"));
        canvas.setBackground(Color.black);
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        jframe.add(canvas);
        jframe.pack();

    }

    public void draw(String imageName, int x, int y) {
        try {
            image = loadImage(imageName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g = canvas.getGraphics();
        g.drawImage(image, x, y, null);
        //g.drawImage(image, x, y, 40,40,null);
    }

    public void drawWithScale(String imageName, int x, int y, int width, int height) {
        try {
            image = loadImage(imageName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g = canvas.getGraphics();
        //g.drawImage(image, x, y, null);
        g.drawImage(image, x, y, width, height, null);
    }

    public static BufferedImage loadImage(String imageName) throws IOException {
        String pathname = "C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\img\\" + imageName + ".png";//MACHS RELATIV
        //System.out.println(pathname);
        File file = new File(pathname);
        BufferedImage bi = ImageIO.read(file);
        return bi;
    }
}

/*
File path = new File("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\IMAGES");
File[] allFiles = path.listFiles();
BufferedImage[] allImages = new BufferedImage[allFiles.length];
for(int i = 0; i < allFiles.length; i++){
try {
allImages[i] = ImageIO.read(allFiles[i]);
} catch (IOException ex) {
ex.printStackTrace();
}
}
return allImages[imageID];
*/
