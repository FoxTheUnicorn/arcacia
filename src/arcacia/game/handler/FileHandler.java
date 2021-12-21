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

public class FileHandler {

    //Geometry
    public static final char wall = 'W';
    public static final char door = 'D';
    public static final char player = 'P';
    public static final char key = 'K';
    public static final char enemy = 'E';//speziell Gegner der auf EmptyTile steht
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

    private static final String filePath = "./Level-editor/Level/";


    /**
     * Nimmt für die Spielfeldgröße die werte in LevelHandler.level_width und LevelHandler.level_height in dieser Klasse
     * öffnet die unter filePath liegende Datei,
     * schreibt den Aktuellen zustand des Level Grids in dei Datei
     * und schreibt darunter die Daten aus den Variablen des PlayerHandlers, ItemHandlers und GameHandlers.
     *
     * @throws FileNotFoundException schmeißt eine FileNotFound Exception, wenn zu öffnende Datei nicht geöffnet werden konnte
     */
    public static void saveGame() throws FileNotFoundException {
        PrintWriter pWriter = new PrintWriter(new FileOutputStream(filePath+"savegame.txt"));
        StringBuilder line = new StringBuilder();
        //schreibt den Aktuellen zustand des Spielfelds in die Datei
        for (int y = 0; y < LevelHandler.level_height; y++) {
            for (int x = 0; x < LevelHandler.level_width; x++) {
                GameObject temp = LevelHandler.getObjectAt(new Location(x, y));
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

        //LevelNumber
        pWriter.println(LevelHandler.getLevel_number());
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


    /**
     * LevelBuilder
     * lies level aus datei aus
     * Baue Level Grid basierend auf datei
     *
     */
    public static void levelBuilder(BufferedReader bReader){
        GameObject[][] new_grid = new GameObject[LevelHandler.level_width][LevelHandler.level_height];

        String line = "";

        for (int y = 0; y < LevelHandler.level_height; y++) {

            try {
                line = bReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

            char now;
            for (int x = 0; x < LevelHandler.level_width; x++) {
                if(x == 1 && y == 1) {
                    int tmp = 0;
                }

                now = line.charAt(x);
                Location loc = new Location(x, y);

                //vergleich welches objekt von dem Character dargestellt wird (19 mal)
                switch (now) {
                    case (wall) -> new_grid[x][y] = new WallTile(loc);
                    case (empty) -> new_grid[x][y] = new EmptyTile(loc);
                    case (player) -> new_grid[x][y] = new PlayerObject(loc);
                    case (key) -> new_grid[x][y] = new Key(loc);
                    case (coin) -> new_grid[x][y] = new CoinItem(loc);
                    case (door) -> new_grid[x][y] = new DoorObject(loc);
                    case (speed) -> new_grid[x][y] = new SpeedBoots(loc);
                    case (healtUp) -> new_grid[x][y] = new ExtraLife(loc);
                    case (stopwatch) -> new_grid[x][y] = new Stopwatch(loc);
                    case (power) -> new_grid[x][y] = new PowerPill(loc);
                    case (multiplikator) -> new_grid[x][y] = new Multiplier(loc);
                    case (enemy) -> new_grid[x][y] = new Enemy(loc);

                    case (Ecoin) -> new_grid[x][y] = new Enemy(loc, new CoinItem(loc));
                    case (Ekey) -> new_grid[x][y] = new Enemy(loc, new Key(loc));
                    case (Emultiplikator) -> new_grid[x][y] = new Enemy(loc, new Multiplier(loc));
                    case (Epower) -> new_grid[x][y] = new Enemy(loc, new PowerPill(loc));
                    case (Espeed) -> new_grid[x][y] = new Enemy(loc, new SpeedBoots(loc));
                    case (EhealtUp) -> new_grid[x][y] = new Enemy(loc, new ExtraLife(loc));
                    case (Estopwatch) -> new_grid[x][y] = new Enemy(loc, new Stopwatch(loc));
                }
            }
        }
        LevelHandler.setLevelGrid(new_grid);

    }

    /**
     * loadLevelX
     * läd ein spezifisches level welches Dann gebaut werden soll
     */
    public static boolean loadLevelX(int i)  {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath+"Level_"+i+".txt"));
            levelBuilder(bufferedReader);
            bufferedReader.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Nimmt für die Spielfeldgröße die werte in LevelHandler.level_width und LevelHandler.level_height in dieser Klasse
     * öffnet Datei die unter filePath liegt,
     * liest das dort liegende Spielfeld aus und legt es in den Grid vom LevelHandler
     * zusätzlich werden die Darunter stehenden Daten in die Variablen des PlayerHandlers, ItemHandlers und GameHandlers gesetzt.
     *
     * @throws FileNotFoundException schmeißt eine FileNotFoundException, wenn die zu öffnende Datei nicht geöffnet werden konnte
     */
    public static void loadGame() throws FileNotFoundException {
       // GameObject[][] new_grid = new GameObject[LevelHandler.level_width][LevelHandler.level_height];
        BufferedReader bReader = new BufferedReader(new FileReader(filePath+"savegame.txt"));
        levelBuilder(bReader);


//        String line = "";
//
//        for (int y = 0; y < LevelHandler.level_height; y++) {
//
//            try {
//                line = bReader.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//                break;
//            }
//
//            char now;
//            for (int x = 0; x < LevelHandler.level_width; x++) {
//
//                now = line.charAt(x);
//                Location loc = new Location(x, y);
//
//                //vergleich welches objekt von dem Character dargestellt wird (19 mal)
//                switch (now) {
//                    case (wall) -> new_grid[x][y] = new WallTile(loc);
//                    case (empty) -> new_grid[x][y] = new EmptyTile(loc);
//                    case (player) -> new_grid[x][y] = new PlayerObject(loc);
//                    case (key) -> new_grid[x][y] = new Key(loc);
//                    case (coin) -> new_grid[x][y] = new CoinItem(loc);
//                    case (door) -> new_grid[x][y] = new DoorObject(loc);
//                    case (speed) -> new_grid[x][y] = new SpeedBoots(loc);
//                    case (healtUp) -> new_grid[x][y] = new ExtraLife(loc);
//                    case (stopwatch) -> new_grid[x][y] = new Stopwatch(loc);
//                    case (power) -> new_grid[x][y] = new PowerPill(loc);
//                    case (multiplikator) -> new_grid[x][y] = new Multiplier(loc);
//                    case (enemy) -> new_grid[x][y] = new Enemy(loc);
//
//                    case (Ecoin) -> new_grid[x][y] = new Enemy(loc, new CoinItem(loc));
//                    case (Ekey) -> new_grid[x][y] = new Enemy(loc, new Key(loc));
//                    case (Emultiplikator) -> new_grid[x][y] = new Enemy(loc, new Multiplier(loc));
//                    case (Epower) -> new_grid[x][y] = new Enemy(loc, new PowerPill(loc));
//                    case (Espeed) -> new_grid[x][y] = new Enemy(loc, new SpeedBoots(loc));
//                    case (EhealtUp) -> new_grid[x][y] = new Enemy(loc, new ExtraLife(loc));
//                    case (Estopwatch) -> new_grid[x][y] = new Enemy(loc, new Stopwatch(loc));
//                }
//            }
//        }
//        LevelHandler.setLevelGrid(new_grid);

        String line = "";
        //werte rest der enthaltenen Daten aus
        try {
            //LevelNumber
            line = bReader.readLine();
            LevelHandler.setLevel_number(Integer.parseInt(line));
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

    /**
     * setzt das LevelGrid auf nur wände, fügt jede Art von Objekt einmal in das Grid ein auf y=5
     * und setzt alle zu speichernden werte in PlayerHandler, ItemHandler und GameHandler auf bestimmte werte
     * führt dan die saveGame() methode aus
     */
    public static void debugTestSaveGame(){
        //LevelHandler.debugInitGrid();
        //setze eins von jeder art objekt auf grid[n][5] starte mit n = 1
        int n = 1;
        //Geometry
        LevelHandler.setObjectAt(new Location(n,5),new DoorObject(new Location(n,5)));n++;
        LevelHandler.setObjectAt(new Location(n,5),new PlayerObject(new Location(n,5)));n++;
        LevelHandler.setObjectAt(new Location(n,5),new Key(new Location(n,5)));n++;
        LevelHandler.setObjectAt(new Location(n,5),new Enemy(new Location(n,5)));n++;
        LevelHandler.setObjectAt(new Location(n,5),new CoinItem(new Location(n,5)));n++;
        LevelHandler.setObjectAt(new Location(n,5),new EmptyTile(new Location(n,5)));n++;
        //Itemsnew
        LevelHandler.setObjectAt(new Location(n,5),new SpeedBoots(new Location(n,5)));n++;
        LevelHandler.setObjectAt(new Location(n,5),new ExtraLife(new Location(n,5)));n++;
        LevelHandler.setObjectAt(new Location(n,5),new Stopwatch(new Location(n,5)));n++;
        LevelHandler.setObjectAt(new Location(n,5),new PowerPill(new Location(n,5)));n++;
        LevelHandler.setObjectAt(new Location(n,5),new Multiplier(new Location(n,5)));n++;
        //Gegner auf Items
        LevelHandler.setObjectAt(new Location(n,5),new Enemy(new Location(n,5),new Key(new Location(n,5))));n++;
        LevelHandler.setObjectAt(new Location(n,5),new Enemy(new Location(n,5),new CoinItem(new Location(n,5))));n++;
        LevelHandler.setObjectAt(new Location(n,5),new Enemy(new Location(n,5),new SpeedBoots(new Location(n,5))));n++;
        LevelHandler.setObjectAt(new Location(n,5),new Enemy(new Location(n,5),new ExtraLife(new Location(n,5))));n++;
        LevelHandler.setObjectAt(new Location(n,5),new Enemy(new Location(n,5),new Stopwatch(new Location(n,5))));n++;
        LevelHandler.setObjectAt(new Location(n,5),new Enemy(new Location(n,5),new PowerPill(new Location(n,5))));n++;
        LevelHandler.setObjectAt(new Location(n,5),new Enemy(new Location(n,5),new Multiplier(new Location(n,5))));

        LevelHandler.setLevel_number(3);

        PlayerHandler.setHasKey(true);
        PlayerHandler.setLives(5);
        PlayerHandler.setScore(500);

        ItemHandler.setPowerPillDuration(50);
        ItemHandler.setMultiplierDuration(60);
        ItemHandler.setSpeedBootsDuration(70);

        GameHandler.setEnemyTimeout(9);
        GameHandler.setPlayerTurn(4);

        try {
            saveGame();
        } catch (FileNotFoundException e) {
            System.out.println("File nicht gefunden in saveGame");
            e.printStackTrace();
        }

    }

    /**
     * führt loadGame() methode aus und gibt dann ein paar der in debugTestSaveGame() gespeicherten werte aus
     * diese sind die werte die von PlayerHandler, ItemHandler und GameHandler gespeichert wurde, gibt auch aus welcher werte in debugTestSaveGame reingespeichert wurden
     * gibt auch einen string aus der reihe y=5 des Grids in den jeweiligen Buchstaben repräsentiert
     */
    public static void debugTestLoadGame(){
        try {
            loadGame();
        } catch (FileNotFoundException e) {
            System.out.println("File nicht gefunden in loadGame");
            e.printStackTrace();
        }

        System.out.println("LevleNumber: "+LevelHandler.getLevel_number()+ " Erwartet: 3");

        System.out.println("hasKey: "+ PlayerHandler.hasKey()+  " Erwartet: true");
        System.out.println("lives: "+ PlayerHandler.getLives()+  " Erwartet: 5");
        System.out.println("score: "+ PlayerHandler.getScore()+  " Erwartet: 500");

        System.out.println("PowerPillDuration: "+ ItemHandler.getPowerPillDuration()+  " Erwartet: 50");
        System.out.println("MultiplierDuration: "+ ItemHandler.getMultiplierDuration()+  " Erwartet: 60");
        System.out.println("SpeedBootsDuration: "+ ItemHandler.getSpeedBootsDuration()+  " Erwartet: 70");

        System.out.println("EnemyTimeout: "+ GameHandler.getEnemyTimeout()+  " Erwartet: 9");
        System.out.println("PlayerTurn: "+ GameHandler.getPlayerTurn() +  " Erwartet: 4");

        //gibt Reihe mit y=5 aus inder sollten alle Objekte einmal liegen
        for (int x = 0; x < LevelHandler.level_width;x++){
            GameObject temp = LevelHandler.getObjectAt(new Location(x, 5));
            if (temp instanceof WallTile) {
                System.out.print(wall);
            } else if (temp instanceof EmptyTile) {
                System.out.print(empty);
            } else if (temp instanceof DoorObject) {
                System.out.print(door);
            } else if (temp instanceof PlayerObject) {
                System.out.print(player);

            } else if (temp instanceof Enemy) {// hier ist bestimmt das auf der postiton ein gegner steht nun wird bestimmt ob der gegner auf einem Item steht und auf welchem

                if (((Enemy) temp).getObjectOnPosition() instanceof EmptyTile) {
                    System.out.print(enemy);
                } else if (((Enemy) temp).getObjectOnPosition() instanceof CoinItem) {
                    System.out.print(Ecoin);
                } else if (((Enemy) temp).getObjectOnPosition() instanceof ExtraLife) {
                    System.out.print(EhealtUp);
                } else if (((Enemy) temp).getObjectOnPosition() instanceof Key) {
                    System.out.print(Ekey);
                } else if (((Enemy) temp).getObjectOnPosition() instanceof Multiplier) {
                    System.out.print(Emultiplikator);
                } else if (((Enemy) temp).getObjectOnPosition() instanceof PowerPill) {
                    System.out.print(Epower);
                } else if (((Enemy) temp).getObjectOnPosition() instanceof SpeedBoots) {
                    System.out.print(Espeed);
                } else if (((Enemy) temp).getObjectOnPosition() instanceof Stopwatch) {
                    System.out.print(Estopwatch);
                }
            } else if (temp instanceof Item) { //hier wurde bestimmt das ein Item auf der Position Liegt, nun wird bestimmt welches
                if (temp instanceof CoinItem) {
                    System.out.print(coin);
                } else if (temp instanceof ExtraLife) {
                    System.out.print(healtUp);
                } else if (temp instanceof Key) {
                    System.out.print(key);
                } else if (temp instanceof Multiplier) {
                    System.out.print(multiplikator);
                } else if (temp instanceof PowerPill) {
                    System.out.print(power);
                } else if (temp instanceof SpeedBoots) {
                    System.out.print(speed);
                } else if (temp instanceof Stopwatch) {
                    System.out.print(stopwatch);
                }

            }
        }

    }
}
