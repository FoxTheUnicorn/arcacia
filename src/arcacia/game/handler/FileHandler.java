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
    public static final char wall= 'W';
    public static final char door= 'D';
    public static final char player='P';
    public static final char key='K';
    public static final char enemy='X';//speziell Gegner der auf EmptyTile steht
    public static final char coin='.';
    public static final char empty='L';
    //Items
    public static final char speed='S';
    public static final char healtUp='H' ;
    public static final char stopwatch='Y' ;
    public static final char power='O' ;
    public static final char multiplikator='C' ;
    //Gegner der auf Item Steht
    public static final char Ekey='1';
    public static final char Ecoin='2';
    public static final char Espeed='3';
    public static final char EhealtUp='4' ;
    public static final char Estopwatch='5' ;
    public static final char Epower='6' ;
    public static final char Emultiplikator='7' ;

    private static final String filePath = "./spielstand/spielstand1.txt";

    public static final int WithGrid = 24;
    public static final int HeightGrid = 15;

    /**
     * Nimmt für die Spielfeldgröße die werte in WithGrid und HeightGrid in dieser Klasse
     * öffnet die unter filePath liegende Datei,
     * schreibt den Aktuellen zustand des Level Grids in dei Datei
     * und schreibt darunter die Daten aus den Variablen des PlayerHandlers, ItemHandlers und GameHandlers.
     * @throws FileNotFoundException schmeißt eine FileNotFound Exception, wenn zu öffnende Datei nicht geöffnet werden konnte
     */
    public void saveGame() throws FileNotFoundException {
        PrintWriter pWriter = new PrintWriter(new FileOutputStream(filePath));
        StringBuilder line = new StringBuilder();
        //schreibt den Aktuellen zustand des Spielfelds in die Datei
        for (int i = 0; i < HeightGrid; i++){
            for (int a = 0;a<WithGrid;a++){
              GameObject temp = LevelHandler.getObjectAt(new Location(a,i));
              if (temp instanceof WallTile){
                  line.append(wall);
              }else if (temp instanceof EmptyTile){
                  line.append(empty);
              }else if (temp instanceof DoorObject){
                  line.append(door);
              }else if (temp instanceof PlayerObject){
                  line.append(player);

              }else if (temp instanceof Enemy){// hier ist bestimmt das auf der postiton ein gegner steht nun wird bestimmt ob der gegner auf einem Item steht und auf welchem

                  if (((Enemy) temp).getObjectOnPosition() instanceof EmptyTile){
                      line.append(enemy);
                  }else if (((Enemy) temp).getObjectOnPosition() instanceof Coin){
                      line.append(Ecoin);
                  }else if (((Enemy) temp).getObjectOnPosition() instanceof ExtraLife){
                      line.append(EhealtUp);
                  }else if (((Enemy) temp).getObjectOnPosition() instanceof Key){
                      line.append(Ekey);
                  }else if (((Enemy) temp).getObjectOnPosition() instanceof Multiplier){
                      line.append(Emultiplikator);
                  }else if (((Enemy) temp).getObjectOnPosition() instanceof PowerPill){
                      line.append(Epower);
                  }else if (((Enemy) temp).getObjectOnPosition() instanceof SpeedBoots){
                      line.append(Espeed);
                  }else if (((Enemy) temp).getObjectOnPosition() instanceof StopwatchItem){
                      line.append(Estopwatch);
                  }
              }else if (temp instanceof Item){ //hier wurde bestimmt das ein Item auf der Position Liegt, nun wird bestimmt welches
                  if (temp instanceof Coin){
                      line.append(coin);
                  }else if (temp instanceof ExtraLife){
                      line.append(healtUp);
                  }else if (temp instanceof Key){
                      line.append(key);
                  }else if (temp instanceof Multiplier){
                      line.append(multiplikator);
                  }else if (temp instanceof PowerPill){
                      line.append(power);
                  }else if (temp instanceof SpeedBoots){
                      line.append(speed);
                  }else if (temp instanceof StopwatchItem){
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

    /**
     * Nimmt für die Spielfeldgröße die werte in WithGrid und HeightGrid in dieser Klasse
     * öffnet Datei die unter filePath liegt,
     * liest das dort liegende Spielfeld aus und legt es in den Grid vom LevelHandler
     * zusätzlich werden die Darunter stehenden Daten in die Variablen des PlayerHandlers, ItemHandlers und GameHandlers gesetzt.
     * @throws FileNotFoundException schmeißt eine FileNotFoundException, wenn die zu öffnende Datei nicht geöffnet werden konnte
     */
    public void loadGame() throws FileNotFoundException {
        GameObject[][] newgrid = new GameObject[WithGrid][HeightGrid];

        BufferedReader bReader = new BufferedReader(new FileReader(filePath));
        String line;
        try {
        for (int i = 0; i< HeightGrid; i++){

                line = bReader.readLine();
                char now;
                for (int a=0; a< WithGrid;a++){
                    now = line.charAt(a);

                    //vergleich welches objekt von dem Character dargestellt wird (19 mal)
                    if (now == wall){
                        newgrid[a][i] = new WallTile(new Location(a,i));
                    }else if (now ==empty){
                        newgrid[a][i] = new EmptyTile(new Location(a,i));
                    }else if (now ==player){
                        newgrid[a][i] = new PlayerObject(new Location(a,i));
                    }else if (now ==key){
                        newgrid[a][i] = new Key(new Location(a,i));
                    }else if (now ==coin){
                        newgrid[a][i] =new Coin(new Location(a,i));
                    }else if (now ==door){
                        newgrid[a][i] = new DoorObject(new Location(a,i));
                    }else if (now ==speed){
                        newgrid[a][i] = new SpeedBoots(new Location(a,i));
                    }else if (now ==healtUp){
                        newgrid[a][i] =new ExtraLife(new Location(a,i));
                    }else if (now ==stopwatch){
                        newgrid[a][i] = new StopwatchItem(new Location(a,i));
                    }else if (now ==power){
                        newgrid[a][i] = new PowerPill(new Location(a,i));
                    }else if (now ==multiplikator){
                        newgrid[a][i] = new Multiplier(new Location(a,i));
                    }else if (now ==enemy){
                        newgrid[a][i] = new Enemy(new Location(a,i));
                    }else if (now ==Ecoin){
                        newgrid[a][i] = new Enemy(new Location(a,i),new Coin(new Location(a,i)));
                    }else if (now ==Ekey){
                        newgrid[a][i] = new Enemy(new Location(a,i),new Key(new Location(a,i)));
                    }else if (now ==Emultiplikator){
                        newgrid[a][i] = new Enemy(new Location(a,i),new Multiplier(new Location(a,i)));
                    }else if (now ==Epower){
                        newgrid[a][i] = new Enemy(new Location(a,i),new PowerPill(new Location(a,i)));
                    }else if (now ==Espeed){
                        newgrid[a][i] = new Enemy(new Location(a,i),new SpeedBoots(new Location(a,i)));
                    }else if (now ==EhealtUp){
                        newgrid[a][i] = new Enemy(new Location(a,i),new ExtraLife(new Location(a,i)));
                    }else if (now ==Estopwatch){
                        newgrid[a][i] = new Enemy(new Location(a,i),new StopwatchItem(new Location(a,i)));
                    }

                }

            }
        }catch (IOException e) {
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
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
