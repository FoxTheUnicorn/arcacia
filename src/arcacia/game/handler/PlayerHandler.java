package arcacia.game.handler;

import arcacia.game.objects.PlayerObject;

public class PlayerHandler extends PlayerObject{
    private static boolean hasKey = false;
    private static int lives = 3;
    private static int score = 0;
    private static int multiplier = 1;
    private static PlayerObject player;


    public static void incrementLives() {
        lives++;
    }
    public static void decrementLives() {
        lives--;
    }

    public int addScore(int score) {
        PlayerHandler.score += /*ItemHandler.getMultiplier() * */ score;
        return PlayerHandler.score;
    }


    //region Getter/Setter
    public static void setSpeed(int speed){PlayerObject.speed = speed;}
    
    public static int getSpeed(){return speed;};

    public static boolean hasKey() {
        return hasKey;
    }

    public static void setHasKey(boolean hasKey) {
        PlayerHandler.hasKey = hasKey;
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        PlayerHandler.lives = lives;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        PlayerHandler.score = score;
    }

    public static void addToScore(int score)
    {
        setScore(getScore() + score * multiplier);
    }

    public static PlayerObject getPlayer() {
        return player;
    }

    public static void setPlayer(PlayerObject player) {
        PlayerHandler.player = player;
    }

    public static int getMultiplier() {
        return multiplier;
    }

    public static void setMultiplier(int multiplier) {
        PlayerHandler.multiplier = multiplier;
    }
    //endregion
}
