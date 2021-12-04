package arcacia.game.handler;

import arcacia.game.objects.GameObject;
import arcacia.game.objects.PlayerObject;
import arcacia.game.objects.enemy.Enemy;
import arcacia.game.util.Location;

public class GameHandler {

    public static boolean isRunning;
    public static int playerTimeout = 0;
    public static volatile int playerTurn = 1;
    public static int enemyTimeout = 0;


    //Setter/Getter

    public void setEnemyTimeout(int enemyTimeout){
        GameHandler.enemyTimeout = enemyTimeout;
    }
    public static int getEnemyTimeout(){
        return enemyTimeout;
    }

    public void setPlayerTimeout(int playerTimeout){
        GameHandler.playerTimeout = playerTimeout;
    }

    public static int getPlayerTimeout(){
        return playerTimeout;
    }

    public void setPlayerTurn(int playerTurn){
        GameHandler.playerTurn = playerTurn;

    }

    public static int getPlayerTurn(){
        return playerTurn;
    }


    public void Gameloop() throws InterruptedException {


        while (playerTurn != 0 && isRunning) {


            playerTurn++;
            /*
                Delay, nach Turn eines Spielers
             */
            Thread.sleep(2000); //

            if(enemyTimeout == 0){

                /*
                    Gegnern Begewen sich
                 */
                enemyTimeout++;

                //
            }
            else{

                /*
                    Gegner wird pausiert und dekrementiert
                 */
                //Gegner hier wird pausiert( später)

                enemyTimeout--;
                Enemy.setStopwatchOn(true);
                Thread.sleep(2000);

            }
            Enemy.setStopwatchOn(false);
           // isRunning = true;
            Thread.sleep(2000);

        }

    }


}


