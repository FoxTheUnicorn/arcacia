package arcacia.game.handler;

import arcacia.Game;
import arcacia.game.util.Location;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;

public class InputHandler implements KeyListener {//EXTENDS GAME HARICINDE BIR CÖZÜM YOLU BULMALIYIM
    public static boolean DIR_UP = false;
    public static boolean DIR_DOWN = false;
    public static boolean DIR_LEFT = false;
    public static boolean DIR_RIGHT = false;

    public static int playerX;
    public static int playerY;
    public static int playerSpeed = 4;

    public static boolean inputReceived = false;

    public int countKeys = 0;
    public int countCollectedCoins = 0;
    public int countDoors=0;
    //public int countSpeed = 0;
    //public int countHealthUp = 0;
    //public int countStopwatchItem = 0;
    //public int countPower = 0;
    //public int countMultiplierItem = 0;
    FileHandler fileHandler = new FileHandler();
    Vector<Location> locVec;
    Vector<Location> locKeyVec;
    Vector<Location> locDoorVec;

    {
        try {
            locVec = fileHandler.analyseMap().get("Coins");
            locKeyVec = fileHandler.analyseMap().get("Keys");
            locDoorVec = fileHandler.analyseMap().get("Doors");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            DIR_UP = true;
            //System.out.println("DIR_UP PRESSED");
            /*if ((playerY - 5 * playerSpeed) >= 0) {
                FileHandler fileHandler = new FileHandler();
                Location location = new Location(playerX,playerY - 5 * playerSpeed);
                try {
                    if(!fileHandler.analyseMap().get("Walls").contains(location)){
                        playerY -= 5 * playerSpeed;
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                //playerY -= 5 * playerSpeed;
            }*/

            //System.out.println(playerX/20);
            //System.out.println((playerY-20)/20);
            try {
                for (int i = 0; i < fileHandler.analyseMap().get("Walls").size(); i++) {
                    //System.out.println("X: " + fileHandler.analyseMap().get("Walls").elementAt(i).getX() + " Y: " +  fileHandler.analyseMap().get("Walls").elementAt(i).getY());
                    int aWert = playerX / 20;
                    int bWert = (playerY - 20) / 20;
                    boolean a = fileHandler.analyseMap().get("Walls").elementAt(i).getX() == bWert;
                    boolean b = fileHandler.analyseMap().get("Walls").elementAt(i).getY() == aWert;

                    if (a && b) {
                        return;
                    }
                }
                //ZÄHLT MEHRFACH

                for (int i = 0; i < locVec.size(); i++) {
                    int aWert = playerX / 20;
                    int bWert = (playerY - 20) / 20;
                    boolean aCoins = locVec.elementAt(i).getX() == bWert;
                    boolean bCoins = locVec.elementAt(i).getY() == aWert;
                    if (aCoins && bCoins) {
                        locVec.remove(locVec.elementAt(i));
                        countCollectedCoins++;
                        System.out.println("Collected coins: " + countCollectedCoins);
                    }
                }

                for (int i = 0; i < locKeyVec.size(); i++) {
                    int aWert = playerX / 20;
                    int bWert = (playerY - 20) / 20;
                    boolean aCoins = locKeyVec.elementAt(i).getX() == bWert;
                    boolean bCoins = locKeyVec.elementAt(i).getY() == aWert;
                    if (aCoins && bCoins) {
                        locKeyVec.remove(locKeyVec.elementAt(i));
                        countKeys++;
                        System.out.println("Collected Keys: " +countKeys);
                    }
                }
                if(countKeys == 1 && locDoorVec.elementAt(0).getX() == (playerY - 20) / 20 && locDoorVec.elementAt(0).getY() == playerX / 20){
                    System.out.println("Door has been unlocked with the key.");
                }
                playerY -= 5 * playerSpeed;

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //System.out.println("playerY VON INPUTHANDLER: " + playerY);
            inputReceived = true;
            //System.out.println(super.playerY);
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            DIR_DOWN = true;
            //System.out.println("DIR_DOWN PRESSED");
            /*if ((playerY + 5 * playerSpeed) <= 15 * 20) {
                playerY += 5 * playerSpeed;
            }
            //System.out.println("playerY VON INPUTHANDLER: " + playerY);*/
            //FileHandler fileHandler = new FileHandler();
            //System.out.println(playerX/20);
            //System.out.println((playerY+20)/20);
            try {
                for (int i = 0; i < fileHandler.analyseMap().get("Walls").size(); i++) {
                    //System.out.println("X: " + fileHandler.analyseMap().get("Walls").elementAt(i).getX() + " Y: " +  fileHandler.analyseMap().get("Walls").elementAt(i).getY());
                    int aWert = playerX / 20;
                    int bWert = (playerY + 20) / 20;
                    boolean a = fileHandler.analyseMap().get("Walls").elementAt(i).getX() == bWert;
                    boolean b = fileHandler.analyseMap().get("Walls").elementAt(i).getY() == aWert;
                    if (a && b) {
                        return;
                    }
                }
                for (int i = 0; i < locVec.size(); i++) {
                    int aWert = playerX / 20;
                    int bWert = (playerY + 20) / 20;
                    boolean aCoins = locVec.elementAt(i).getX() == bWert;
                    boolean bCoins = locVec.elementAt(i).getY() == aWert;
                    if (aCoins && bCoins) {
                        locVec.remove(locVec.elementAt(i));
                        countCollectedCoins++;
                        System.out.println("Collected coins: " + countCollectedCoins);
                    }
                }
                for (int i = 0; i < locKeyVec.size(); i++) {
                    int aWert = playerX / 20;
                    int bWert = (playerY + 20) / 20;
                    boolean aCoins = locKeyVec.elementAt(i).getX() == bWert;
                    boolean bCoins = locKeyVec.elementAt(i).getY() == aWert;
                    if (aCoins && bCoins) {
                        locKeyVec.remove(locKeyVec.elementAt(i));
                        countKeys++;
                        System.out.println("Collected keys: " + countKeys);
                    }
                }
                if(countKeys == 1 && locDoorVec.elementAt(0).getX() == (playerY + 20) / 20 && locDoorVec.elementAt(0).getY() == playerX / 20){
                    System.out.println("Door has been unlocked with the key.");
                }

                playerY += 5 * playerSpeed;

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            inputReceived = true;
            //System.out.println(super.playerY);
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            DIR_LEFT = true;
            //System.out.println("DIR_LEFT PRESSED");
            /*if ((playerX - 5 * playerSpeed) >= 0) {
                playerX -= 5 * playerSpeed;
            }*/
            //FileHandler fileHandler = new FileHandler();
            //System.out.println(((playerX+20)/20));
            //System.out.println(playerY/20);
            try {
                for (int i = 0; i < fileHandler.analyseMap().get("Walls").size(); i++) {
                    //System.out.println("X: " + fileHandler.analyseMap().get("Walls").elementAt(i).getX() + " Y: " +  fileHandler.analyseMap().get("Walls").elementAt(i).getY());
                    int aWert = ((playerX - 20) / 20);
                    int bWert = playerY / 20;
                    boolean a = fileHandler.analyseMap().get("Walls").elementAt(i).getX() == bWert;
                    boolean b = fileHandler.analyseMap().get("Walls").elementAt(i).getY() == aWert;
                    if (a && b) {
                        return;
                    }
                }

                for (int i = 0; i < locVec.size(); i++) {
                    int aWert = ((playerX - 20) / 20);
                    int bWert = playerY / 20;
                    boolean aCoins = locVec.elementAt(i).getX() == bWert;
                    boolean bCoins = locVec.elementAt(i).getY() == aWert;
                    if (aCoins && bCoins) {
                        locVec.remove(locVec.elementAt(i));
                        countCollectedCoins++;
                        System.out.println("Collected coins: " + countCollectedCoins);
                    }
                }

                for (int i = 0; i < locKeyVec.size(); i++) {
                    int aWert = ((playerX - 20) / 20);
                    int bWert = playerY / 20;
                    boolean aCoins = locKeyVec.elementAt(i).getX() == bWert;
                    boolean bCoins = locKeyVec.elementAt(i).getY() == aWert;
                    if (aCoins && bCoins) {
                        locKeyVec.remove(locKeyVec.elementAt(i));
                        countKeys++;
                        System.out.println("Collected keys: " + countKeys);
                    }
                }
                if(countKeys == 1 && locDoorVec.elementAt(0).getX() == playerY / 20 && locDoorVec.elementAt(0).getY() == ((playerX - 20) / 20)){
                    System.out.println("Door has been unlocked with the key.");
                }

                playerX -= 5 * playerSpeed;

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            inputReceived = true;
            //System.out.println(playerX);
            //System.out.println(super.playerX);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            DIR_RIGHT = true;
            //System.out.println("DIR_RIGHT PRESSED");
            /*if ((playerX + 5 * playerSpeed) <= 25 *20) {
                playerX += 5 * playerSpeed;
            }*/
            //FileHandler fileHandler = new FileHandler();
            //System.out.println(((playerX+20)/20));
            //System.out.println(playerY/20);
            try {
                for (int i = 0; i < fileHandler.analyseMap().get("Walls").size(); i++) {
                    //System.out.println("X: " + fileHandler.analyseMap().get("Walls").elementAt(i).getX() + " Y: " +  fileHandler.analyseMap().get("Walls").elementAt(i).getY());
                    int aWert = ((playerX + 20) / 20);
                    int bWert = playerY / 20;
                    boolean a = fileHandler.analyseMap().get("Walls").elementAt(i).getX() == bWert;
                    boolean b = fileHandler.analyseMap().get("Walls").elementAt(i).getY() == aWert;
                    if (a && b) {
                        return;
                    }
                }
                for (int i = 0; i < locVec.size(); i++) {
                    int aWert = ((playerX + 20) / 20);
                    int bWert = playerY / 20;
                    boolean aCoins = locVec.elementAt(i).getX() == bWert;
                    boolean bCoins = locVec.elementAt(i).getY() == aWert;
                    if (aCoins && bCoins) {
                        locVec.remove(locVec.elementAt(i));
                        countCollectedCoins++;
                        System.out.println("Collected coins: " + countCollectedCoins);
                    }
                }

                for (int i = 0; i < locKeyVec.size(); i++) {
                    int aWert = ((playerX + 20) / 20);
                    int bWert = playerY / 20;
                    boolean aCoins = locKeyVec.elementAt(i).getX() == bWert;
                    boolean bCoins = locKeyVec.elementAt(i).getY() == aWert;
                    if (aCoins && bCoins) {
                        locKeyVec.remove(locKeyVec.elementAt(i));
                        countKeys++;
                        System.out.println("Collected keys: " + countKeys);
                    }
                }
                if(countKeys == 1 && locDoorVec.elementAt(0).getX() == playerY / 20 && locDoorVec.elementAt(0).getY() == ((playerX + 20) / 20)){
                    System.out.println("Door has been unlocked with the key.");
                }

                playerX += 5 * playerSpeed;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            inputReceived = true;
            //System.out.println(playerX);
            //System.out.println(super.playerX);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            DIR_UP = false;
            //System.out.println("DIR_UP RELEASED");
            inputReceived = false;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            DIR_DOWN = false;
            //System.out.println("DIR_DOWN RELEASED");
            inputReceived = false;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            DIR_LEFT = false;
            //System.out.println("DIR_LEFT RELEASED");
            inputReceived = false;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            DIR_DOWN = false;
            //System.out.println("DIR_RIGHT RELEASED");
            inputReceived = false;
        }
    }


}
