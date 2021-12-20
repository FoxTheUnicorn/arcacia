package arcacia.game.handler;

import arcacia.game.objects.enemy.Enemy;

import java.util.ArrayList;

public class ItemHandler {
    private static int powerPillDuration = 0;
    private static int multiplierDuration = 0;
    private static int speedBootsDuration = 0;



    public static void tick() {
        if(powerPillDuration > 0) powerPillDuration--;
        if(multiplierDuration > 0) multiplierDuration--;
        if(speedBootsDuration > 0) speedBootsDuration--;

        if(speedBootsDuration == 0) GameHandler.setPlayerTurn(ConstantHandler.gamePlayerStepsPerTurn);
        if(multiplierDuration == 0) PlayerHandler.setMultiplier(ConstantHandler.scoreDefaultMultiplier);
    }

    //region Functions
    public static boolean isMultiplierActive() { return multiplierDuration > 0; }
    public static void activateMultiplier() {
        multiplierDuration = ConstantHandler.itemMultiplierDuration;
        PlayerHandler.setMultiplier(ConstantHandler.itemMultiplierBuff);
    }

    public static boolean isPowerPillActive() {
        return powerPillDuration > 0;
    }
    public static void activatePowerPill() {
        powerPillDuration = ConstantHandler.itemPowerPillDuration;
    }

    public static boolean isSpeedBootsActive() {
        return speedBootsDuration > 0;
    }
    public static void activateSpeedBoots() {
        GameHandler.setPlayerTurn(ConstantHandler.itemSpeedBootsBuff);
        speedBootsDuration = ConstantHandler.itemSpeedBootsDuration;
    }

    public static int getSpeedBootsDuration() {
        return speedBootsDuration;
    }

    public static void setSpeedBootsDuration(int speedBootsDuration) {
        ItemHandler.speedBootsDuration = speedBootsDuration;
    }

    public static int getMultiplierDuration() {
        return multiplierDuration;
    }

    public static void setMultiplierDuration(int multiplierDuration) {
        ItemHandler.multiplierDuration = multiplierDuration;
    }

    public static int getPowerPillDuration() {
        return powerPillDuration;
    }

    public static void setPowerPillDuration(int powerPillDuration) {
        ItemHandler.powerPillDuration = powerPillDuration;
    }
    //endregion
}