package arcacia.game.handler;

import arcacia.game.objects.GameObject;
import arcacia.game.objects.PlayerObject;
import arcacia.game.objects.enemy.Enemy;
import arcacia.game.objects.item.*;
import arcacia.game.objects.tile.DoorObject;
import arcacia.game.objects.tile.EmptyTile;
import arcacia.game.objects.tile.WallTile;
import arcacia.game.util.Location;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;

public class FileHandler {

    //Geometry
    public static final char wall = 'W';
    public static final char door = 'D';
    public static final char player = 'P';
    public static final char key = 'K';
    public static final char enemy = 'X';//speziell Gegner der auf EmptyTile steht
    public static final char coin = '.';
    public static final char empty = 'L';
    //Items
    public static final char speed = 'S';
    public static final char healtUp = 'H';
    public static final char stopwatch = 'Y';
    public static final char power = 'O';
    public static final char multiplikator = 'C';
    //Gegner der auf Item Steht
    public static final char Ekey = '1';
    public static final char Ecoin = '2';
    public static final char Espeed = '3';
    public static final char EhealtUp = '4';
    public static final char Estopwatch = '5';
    public static final char Epower = '6';
    public static final char Emultiplikator = '7';

    //private static final String filePath = "./spielstand/spielstand1.txt";
    private static final String filePath = "src/spielstand1.txt";//MUSS VERÄNDERT WERDEN

    public static final int WithGrid = 25;
    public static final int HeightGrid = 15;

    /**
     * Nimmt für die Spielfeldgröße die werte in WithGrid und HeightGrid in dieser Klasse
     * öffnet die unter filePath liegende Datei,
     * schreibt den Aktuellen zustand des Level Grids in dei Datei
     * und schreibt darunter die Daten aus den Variablen des PlayerHandlers, ItemHandlers und GameHandlers.
     *
     * @throws FileNotFoundException schmeißt eine FileNotFound Exception, wenn zu öffnende Datei nicht geöffnet werden konnte
     */
    public void saveGame() throws FileNotFoundException {
        PrintWriter pWriter = new PrintWriter(new FileOutputStream(filePath));
        StringBuilder line = new StringBuilder();
        //schreibt den Aktuellen zustand des Spielfelds in die Datei
        for (int i = 0; i < HeightGrid; i++) {
            for (int a = 0; a < WithGrid; a++) {
                GameObject temp = LevelHandler.getObjectAt(new Location(a, i));
                if (temp instanceof WallTile) {
                    line.append(wall);
                } else if (temp instanceof EmptyTile) {
                    line.append(empty);
                } else if (temp instanceof DoorObject) {
                    line.append(door);
                } else if (temp instanceof PlayerObject) {
                    line.append(player);

                } else if (temp instanceof Enemy) {// hier ist bestimmt das auf der postiton ein gegner steht nun wird bestimmt ob der gegner auf einem Item steht und auf welchem

                    if (((Enemy) temp).getObjectOnPosition() instanceof EmptyTile) {
                        line.append(enemy);
                    } else if (((Enemy) temp).getObjectOnPosition() instanceof CoinItem) {
                        line.append(Ecoin);
                    } else if (((Enemy) temp).getObjectOnPosition() instanceof ExtraLife) {
                        line.append(EhealtUp);
                    } else if (((Enemy) temp).getObjectOnPosition() instanceof Key) {
                        line.append(Ekey);
                    } else if (((Enemy) temp).getObjectOnPosition() instanceof Multiplier) {
                        line.append(Emultiplikator);
                    } else if (((Enemy) temp).getObjectOnPosition() instanceof PowerPill) {
                        line.append(Epower);
                    } else if (((Enemy) temp).getObjectOnPosition() instanceof SpeedBoots) {
                        line.append(Espeed);
                    } else if (((Enemy) temp).getObjectOnPosition() instanceof Stopwatch) {
                        line.append(Estopwatch);
                    }
                } else if (temp instanceof Item) { //hier wurde bestimmt das ein Item auf der Position Liegt, nun wird bestimmt welches
                    if (temp instanceof CoinItem) {
                        line.append(coin);
                    } else if (temp instanceof ExtraLife) {
                        line.append(healtUp);
                    } else if (temp instanceof Key) {
                        line.append(key);
                    } else if (temp instanceof Multiplier) {
                        line.append(multiplikator);
                    } else if (temp instanceof PowerPill) {
                        line.append(power);
                    } else if (temp instanceof SpeedBoots) {
                        line.append(speed);
                    } else if (temp instanceof Stopwatch) {
                        line.append(stopwatch);
                    }
                }
            }
            pWriter.println(line);
            line = new StringBuilder();
        }
        //schreibt die Restlichen zu merkenden Variablen in die Datei in einer Bestimten Reihenfolge

        //PlayerHandler
        pWriter.println(PlayerHandler.hasKey());
        pWriter.println(PlayerHandler.getLives());
        pWriter.println(PlayerHandler.getScore());
        //ItemHandler
        pWriter.println(ItemHandler.getPowerPillDuration());
        pWriter.println(ItemHandler.getMultiplierDuration());
        pWriter.println(ItemHandler.getSpeedBootsDuration());
        //GameHandler
        pWriter.println(GameHandler.getEnemyTimeout());
        pWriter.println(GameHandler.getPlayerTurn());

        pWriter.close();
    }

    public String[][] readMap() throws IOException {
        String[][] displaygrid = new String[HeightGrid][WithGrid];
        String stringArray;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int i = 0;
        while (reader.ready()) {
            stringArray = reader.readLine();
            //System.out.println(stringArray);
            for (int j = 0; j < WithGrid; j++) {
                displaygrid[i][j] = String.valueOf(stringArray.charAt(j));
                //System.out.println(i + j + displaygrid[i][j]);
            }
            i++;
        }
        reader.close();
        return displaygrid;
        //String currentLine = reader.readLine();
    }

    public HashMap<String, Vector<Location>> analyseMap() throws IOException {
        String[][] displaygrid = readMap();
            HashMap<String, Vector<Location>> whereabout = new HashMap();
        Vector<Location> locationW = new Vector<>();
        Vector<Location> locationD = new Vector<>();
        Vector<Location> locationP = new Vector<>();
        Vector<Location> locationK = new Vector<>();
        Vector<Location> locationE = new Vector<>();
        Vector<Location> locationPunkt = new Vector<>();
        Vector<Location> locationL = new Vector<>();
        Vector<Location> locationS = new Vector<>();
        Vector<Location> locationH = new Vector<>();
        Vector<Location> locationY = new Vector<>();
        Vector<Location> location0 = new Vector<>();
        Vector<Location> locationC = new Vector<>();

        for (int i = 0; i < HeightGrid; i++) {
            for (int j = 0; j < WithGrid; j++) {
                if (displaygrid[i][j].equals("W")) {
                    Location location = new Location(i, j);
                    locationW.add(location);
                } else if (displaygrid[i][j].equals("D")) {
                    Location location = new Location(i, j);
                    locationD.add(location);
                } else if (displaygrid[i][j].equals("P")) {
                    Location location = new Location(i, j);
                    locationP.add(location);
                } else if (displaygrid[i][j].equals("K")) {
                    Location location = new Location(i, j);
                    locationK.add(location);
                } else if (displaygrid[i][j].equals("E")) {
                    Location location = new Location(i, j);
                    locationE.add(location);
                } else if (displaygrid[i][j].equals(".")) {
                    Location location = new Location(i, j);
                    locationPunkt.add(location);
                } else if (displaygrid[i][j].equals("L")) {
                    Location location = new Location(i, j);
                    locationL.add(location);
                } else if (displaygrid[i][j].equals("S")) {
                    Location location = new Location(i, j);
                    locationS.add(location);
                } else if (displaygrid[i][j].equals("H")) {
                    Location location = new Location(i, j);
                    locationH.add(location);
                } else if (displaygrid[i][j].equals("Y")) {
                    Location location = new Location(i, j);
                    locationY.add(location);
                } else if (displaygrid[i][j].equals("O")) {
                    Location location = new Location(i, j);
                    location0.add(location);
                } else if (displaygrid[i][j].equals("C")) {
                    Location location = new Location(i, j);
                    locationC.add(location);
                }
            }
        }
        whereabout.put("Walls", locationW);
        whereabout.put("Doors", locationD);
        whereabout.put("Players", locationP);
        whereabout.put("Keys", locationK);
        whereabout.put("Enemies", locationE);
        whereabout.put("Coins", locationPunkt);
        whereabout.put("Empty Spaces", locationL);
        whereabout.put("Speed", locationS);
        whereabout.put("HealthUp", locationH);
        whereabout.put("StopwatchItem", locationY);
        whereabout.put("Power", location0);
        whereabout.put("MultiplierItem", locationC);
        return whereabout;
    }

    public HashMap<String, Integer> inventoryList() throws IOException {
        String[][] displaygrid = readMap();
        int Walls = 0;
        int Doors = 0;
        int Players = 0;
        int Keys = 0;
        int Enemies = 0;
        int Coins = 0;
        int EmptySpaces = 0;
        int Speed = 0;
        int HealthUp = 0;
        int StopwatchItem = 0;
        int Power = 0;
        int MultiplierItem = 0;

        HashMap<String, Integer> inventory = new HashMap<>();
        for (int i = 0; i < HeightGrid; i++) {
            for (int j = 0; j < WithGrid; j++) {
                if (displaygrid[i][j].equals("W")) {
                    inventory.put("Walls", ++Walls);
                } else if (displaygrid[i][j].equals("D")) {
                    inventory.put("Doors", ++Doors);
                } else if (displaygrid[i][j].equals("P")) {
                    inventory.put("Players", ++Players);
                } else if (displaygrid[i][j].equals("K")) {
                    inventory.put("Keys", ++Keys);
                } else if (displaygrid[i][j].equals("E")) {
                    inventory.put("Enemies", ++Enemies);
                } else if (displaygrid[i][j].equals(".")) {
                    inventory.put("Coins", ++Coins);
                } else if (displaygrid[i][j].equals("L")) {
                    inventory.put("Empty Spaces", ++EmptySpaces);
                } else if (displaygrid[i][j].equals("S")) {
                    inventory.put("Speed", ++Speed);
                } else if (displaygrid[i][j].equals("H")) {
                    inventory.put("HealthUp", ++HealthUp);
                } else if (displaygrid[i][j].equals("Y")) {
                    inventory.put("StopwatchItem", ++StopwatchItem);
                } else if (displaygrid[i][j].equals("O")) {
                    inventory.put("Power", ++Power);
                } else if (displaygrid[i][j].equals("C")) {
                    inventory.put("MultiplierItem", ++MultiplierItem);
                }
            }
        }
        return inventory;
    }


    /**
     * Nimmt für die Spielfeldgröße die werte in WithGrid und HeightGrid in dieser Klasse
     * öffnet Datei die unter filePath liegt,
     * liest das dort liegende Spielfeld aus und legt es in den Grid vom LevelHandler
     * zusätzlich werden die Darunter stehenden Daten in die Variablen des PlayerHandlers, ItemHandlers und GameHandlers gesetzt.
     *
     * @throws FileNotFoundException schmeißt eine FileNotFoundException, wenn die zu öffnende Datei nicht geöffnet werden konnte
     */
    public void loadGame() throws FileNotFoundException {
        GameObject[][] newgrid = new GameObject[WithGrid][HeightGrid];


        BufferedReader bReader = new BufferedReader(new FileReader(filePath));
        String line;
        try {
            for (int i = 0; i < HeightGrid; i++) {

                line = bReader.readLine();
                char now;
                for (int a = 0; a < WithGrid; a++) {
                    now = line.charAt(a);

                    //vergleich welches objekt von dem Character dargestellt wird (19 mal)
                    if (now == wall) {
                        newgrid[a][i] = new WallTile(new Location(a, i));
                    } else if (now == empty) {
                        newgrid[a][i] = new EmptyTile(new Location(a, i));
                    } else if (now == player) {
                        newgrid[a][i] = new PlayerObject(new Location(a, i));
                    } else if (now == key) {
                        newgrid[a][i] = new Key(new Location(a, i));
                    } else if (now == coin) {
                        newgrid[a][i] = new CoinItem(new Location(a, i));
                    } else if (now == door) {
                        newgrid[a][i] = new DoorObject(new Location(a, i));
                    } else if (now == speed) {
                        newgrid[a][i] = new SpeedBoots(new Location(a, i));
                    } else if (now == healtUp) {
                        newgrid[a][i] = new ExtraLife(new Location(a, i));
                    } else if (now == stopwatch) {
                        newgrid[a][i] = new Stopwatch(new Location(a, i));
                    } else if (now == power) {
                        newgrid[a][i] = new PowerPill(new Location(a, i));
                    } else if (now == multiplikator) {
                        newgrid[a][i] = new Multiplier(new Location(a, i));
                    } else if (now == enemy) {
                        newgrid[a][i] = new Enemy(new Location(a, i));
                    } else if (now == Ecoin) {
                        newgrid[a][i] = new Enemy(new Location(a, i), new CoinItem(new Location(a, i)));
                    } else if (now == Ekey) {
                        newgrid[a][i] = new Enemy(new Location(a, i), new Key(new Location(a, i)));
                    } else if (now == Emultiplikator) {
                        newgrid[a][i] = new Enemy(new Location(a, i), new Multiplier(new Location(a, i)));
                    } else if (now == Epower) {
                        newgrid[a][i] = new Enemy(new Location(a, i), new PowerPill(new Location(a, i)));
                    } else if (now == Espeed) {
                        newgrid[a][i] = new Enemy(new Location(a, i), new SpeedBoots(new Location(a, i)));
                    } else if (now == EhealtUp) {
                        newgrid[a][i] = new Enemy(new Location(a, i), new ExtraLife(new Location(a, i)));
                    } else if (now == Estopwatch) {
                        newgrid[a][i] = new Enemy(new Location(a, i), new Stopwatch(new Location(a, i)));
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        LevelHandler.setLevelGrid(newgrid);

        //werte rest der enthaltenen Daten aus
        try {
            //PlayerHandler
            //hasKey
            line = bReader.readLine();
            PlayerHandler.setHasKey(Boolean.parseBoolean(line));
            //lives
            line = bReader.readLine();
            PlayerHandler.setLives(Integer.parseInt(line));
            //Score
            line = bReader.readLine();
            PlayerHandler.setScore(Integer.parseInt(line));

            //ItemHandler
            //powerPillDuration
            line = bReader.readLine();
            ItemHandler.setPowerPillDuration(Integer.parseInt(line));
            //multiplierDuration
            line = bReader.readLine();
            ItemHandler.setMultiplierDuration(Integer.parseInt(line));
            //speedBootsDuration
            line = bReader.readLine();
            ItemHandler.setSpeedBootsDuration(Integer.parseInt(line));

            //GameHandler
            //enemyTimeout
            line = bReader.readLine();
            GameHandler.setEnemyTimeout(Integer.parseInt(line));
            //PlayerTurn
            line = bReader.readLine();
            GameHandler.setPlayerTurn(Integer.parseInt(line));

            //schließe Datei
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}