package arcacia;
//import arcacia.game.handler.InputHandler;

import arcacia.game.handler.FileHandler;
import arcacia.game.handler.InputHandler;
import arcacia.game.util.Location;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static arcacia.Display.canvas;
import static arcacia.Display.loadImage;

public class Game extends InputHandler implements Runnable {
    public Display display;
    public boolean started = false;
    public boolean running = false;
    public Thread gameThread;
    public int previousPositionX;
    public int previousPositionY;
    String imageName;
    public static int Scale = 16;
    public static int linearFactor = 20;
    FileHandler fileHandler;
    boolean coldStartEnded = false;

    public Game() {

    }

    public synchronized void start() {
        gameThread = new Thread(this);
        gameThread.start();
        running = true;
    }

    public void stop() {
        try {
            gameThread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initialiseDisplay() {
        display = new Display("DrawImageOnCanvas", 15 * linearFactor, 25 * linearFactor);
        started = true;
    }

    public void draw(String image, int x, int y) {
        /*if(started == false){
            display = new Display("DrawImageOnCanvas", x*Scale, y*Scale);
            started = true;
            //System.out.println("ORIGIN");
        }*/
        display.drawWithScale(image, playerX, playerY, 20, 20);
        //System.out.println(playerX);
        //System.out.println("playerY VON GAME: " + super.playerY);
        //System.out.println("DREW");
    }

    public void update() {
        //System.out.println("playerX: " + playerX + " playerY: " + playerY);

    }

    public void drawMap() throws IOException {
        FileHandler fileHandler = new FileHandler();
        try {
            String[][] stringArray = fileHandler.readMap();
            fileHandler.analyseMap();
            //System.out.println(stringArray);
            int width = 20, height = 20;
            for (int i = 0; i < fileHandler.HeightGrid; i++) {
                for (int j = 0; j < fileHandler.WithGrid; j++) {
                    if (stringArray[i][j].equals("W")) {
                        //System.out.println("HATA YOK i: " + i + " j: " + j);
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("Wall", linearFactor * j, linearFactor * i, width, height);
                    } else if (stringArray[i][j].equals("D")) {
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("Door", linearFactor * j, linearFactor * i, width, height);
                    } else if (stringArray[i][j].equals("C")) {
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("Multiplier", linearFactor * j, linearFactor * i, width, height);
                    } else if (stringArray[i][j].equals("K")) {
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("Key", linearFactor * j, linearFactor * i, width, height);
                    } else if (stringArray[i][j].equals(".")) {
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("Coin", linearFactor * j, linearFactor * i, width, height);
                    } else if (stringArray[i][j].equals("L")) {
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("Leer", linearFactor * j, linearFactor * i, width, height);
                    } else if (stringArray[i][j].equals("E")) {//
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("Enemy", linearFactor * j, linearFactor * i, width, height);
                    } else if (stringArray[i][j].equals("P")) {//
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("Player", linearFactor * j, linearFactor * i, width, height);
                    } else if (stringArray[i][j].equals("O")) {
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("PowerPill", linearFactor * j, linearFactor * i, width, height);
                    } else if (stringArray[i][j].equals("S")) {
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("SpeedBoots", linearFactor * j, linearFactor * i, width, height);
                    } else if (stringArray[i][j].equals("H")) {
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("HPUp", linearFactor * j, linearFactor * i, width, height);
                    } else if (stringArray[i][j].equals("Y")) {
                        //System.out.println(stringArray[i][j]);
                        display.drawWithScale("Stopwatch", linearFactor * j, linearFactor * i, width, height);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        initialiseDisplay();
        FileHandler fileHandler = new FileHandler();
        try {
            playerY = 20 * fileHandler.analyseMap().get("Players").elementAt(0).getX();
            //System.out.println(playerY);
            playerX = 20 * fileHandler.analyseMap().get("Players").elementAt(0).getY();
            //System.out.println(playerX);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            drawMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (gameThread != null) {
            //this.requestFocus();
            final int MAX_FRAMES_PER_SECOND = 60;
            final int MAX_UPDATES_PER_SECOND = 60;

            final double uOPTIMAL_TIME = 1000000000 / MAX_UPDATES_PER_SECOND;
            final double fOPTIMAL_TIME = 1000000000 / MAX_FRAMES_PER_SECOND;

            double uDeltaTime = 0, fDeltaTime = 0;
            int frames = 0, updates = 0;
            long startTime = System.nanoTime();
            long timer = System.currentTimeMillis();
            while (running) {
                long currentTime = System.nanoTime();
                uDeltaTime += (currentTime - startTime);
                fDeltaTime += (currentTime - startTime);
                startTime = currentTime;

                if (uDeltaTime >= uOPTIMAL_TIME) {
                    update();
                    updates++;
                    uDeltaTime -= uOPTIMAL_TIME;
                }
                if (fDeltaTime >= fOPTIMAL_TIME) {
                    //System.out.println("DRAWING IT");
                    //TEK SORUN BASLANGICTA GÖZÜKMÜYOR
                    //display.jframe.dispose();
                    //display.canvas.getGraphics().fillRect(previousPositionX, previousPositionY, display.loadImage(imageName).getWidth(),display.loadImage(imageName).getHeight());
                    if (inputReceived) {//KEY PRESSED
                        //Display.canvas.getGraphics().clearRect(previousPositionX, previousPositionY, display.loadImage(imageName).getWidth(), display.loadImage(imageName).getHeight());
                        //DÜSÜK KALITE BIR CÖZÜM
                        if (coldStartEnded) {
                            Display.canvas.getGraphics().clearRect(previousPositionX, previousPositionY, 20, 20);
                        }
                        coldStartEnded = true;
                        //DÜSÜK KALITE BIR CÖZÜM
                        try {
                            Display.canvas.getGraphics().clearRect(20 * fileHandler.analyseMap().get("Players").elementAt(0).getY(), 20 * fileHandler.analyseMap().get("Players").elementAt(0).getX(), 20, 20);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //ILK TURDA ÜST SOL KÖSEYI SILIYOR
                        draw(imageName, playerX, playerY);
                        previousPositionX = playerX;
                        previousPositionY = playerY;
                    }
                    frames++;
                    fDeltaTime -= fOPTIMAL_TIME;
                }
                if (System.currentTimeMillis() - timer >= 1000) {
                    //System.out.println("UPS: " + updates + ", FPS: " + frames);
                    //if(started){System.out.println("STARTED");}
                    updates = 0;
                    frames = 0;
                    timer += 1000;
                }
            }
            stop();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.imageName = "Player";
        game.start();
    }

}
