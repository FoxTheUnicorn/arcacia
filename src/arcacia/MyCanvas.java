package arcacia;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyCanvas extends Canvas {
    Image image;
    @Override
    public void paint(Graphics g){
        setPreferredSize(new Dimension(750,750));
        setMaximumSize(new Dimension(750,750));
        setMinimumSize(new Dimension(750,750));
        setBackground(Color.black);
        //Ilk görsel icin deneme
        g.drawImage(image,250,250,this);
    }
    public MyCanvas(int imageID){
        File path = new File("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\IMAGES");
        /*
        The listFiles() method is a part of File class.The function returns an array of Files denoting the files in a given abstract pathname if the
        path name is a directory else returns null.
        */
        File[] allFiles = path.listFiles();
        //Kac görsel varsa o kadar yer ayriliyor allImages Array'i icerisinde
        Image[] allImages = new Image[allFiles.length];
        //To load an image from a specific file use the following code, which is from LoadImageApp.java:
        for(int i = 0; i < allFiles.length; i++){
            try {
                allImages[i] = ImageIO.read(allFiles[i]);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        image = allImages[imageID];
    }
}
