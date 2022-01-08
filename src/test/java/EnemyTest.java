import arcacia.game.handler.LevelHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.objects.GameObject;
import arcacia.game.objects.PlayerObject;
import arcacia.game.objects.enemy.Enemy;
import arcacia.game.objects.item.*;
import arcacia.game.objects.tile.EmptyTile;
import arcacia.game.objects.tile.WallTile;
import arcacia.game.util.Location;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {


    @BeforeEach
    public void setup(){

        LevelHandler.debugInitGrid(EmptyTile.class);
        //Für move Tests
        //Xp
        LevelHandler.setObjectAt(new Location(3,2),new CoinItem(new Location(3,2)));
        LevelHandler.setObjectAt(new Location(5,2),new ExtraLife(new Location(5,2)));
        LevelHandler.setObjectAt(new Location(7,2),new Key(new Location(7,2)));
        LevelHandler.setObjectAt(new Location(9,2),new Multiplier(new Location(9,2)));
        LevelHandler.setObjectAt(new Location(11,2),new PowerPill(new Location(11,2)));
        LevelHandler.setObjectAt(new Location(13,2),new SpeedBoots(new Location(13,2)));
        LevelHandler.setObjectAt(new Location(15,2),new Stopwatch(new Location(15,2)));
        LevelHandler.setObjectAt(new Location(17,2),new WallTile(new Location(17,2)));

        //Xn
        LevelHandler.setObjectAt(new Location(19,4),new CoinItem(new Location(19,4)));
        LevelHandler.setObjectAt(new Location(17,4),new ExtraLife(new Location(17,4)));
        LevelHandler.setObjectAt(new Location(15,4),new Key(new Location(15,4)));
        LevelHandler.setObjectAt(new Location(13,4),new Multiplier(new Location(13,4)));
        LevelHandler.setObjectAt(new Location(11,4),new PowerPill(new Location(11,4)));
        LevelHandler.setObjectAt(new Location(9,4),new SpeedBoots(new Location(9,4)));
        LevelHandler.setObjectAt(new Location(7,4),new Stopwatch(new Location(7,4)));
        LevelHandler.setObjectAt(new Location(5,4),new WallTile(new Location(5,4)));

        //Yp
        LevelHandler.setObjectAt(new Location(2,1),new CoinItem(new Location(2,2)));
        LevelHandler.setObjectAt(new Location(2,3),new ExtraLife(new Location(2,4)));
        LevelHandler.setObjectAt(new Location(2,5),new Key(new Location(2,6)));
        LevelHandler.setObjectAt(new Location(2,7),new Multiplier(new Location(2,8)));
        LevelHandler.setObjectAt(new Location(2,9),new PowerPill(new Location(2,10)));
        LevelHandler.setObjectAt(new Location(2,11),new SpeedBoots(new Location(12,3)));
        //LevelHandler.setObjectAt(new Location(2,14),new Stopwatch(new Location(2,14))); entfernt um Layout passender zu machen
        LevelHandler.setObjectAt(new Location(2,13),new WallTile(new Location(2,14)));

        //Yn
        LevelHandler.setObjectAt(new Location(4,13),new CoinItem(new Location(4,14)));
        LevelHandler.setObjectAt(new Location(4,11),new ExtraLife(new Location(4,12)));
        LevelHandler.setObjectAt(new Location(4,9),new Key(new Location(4,10)));
        LevelHandler.setObjectAt(new Location(4,7),new Multiplier(new Location(4,8)));
        LevelHandler.setObjectAt(new Location(4,5),new PowerPill(new Location(4,6)));
        LevelHandler.setObjectAt(new Location(4,3),new SpeedBoots(new Location(4,4)));
        //LevelHandler.setObjectAt(new Location(4,y),new Stopwatch(new Location(4,y))); entfernt um Layout passender zu machen
        LevelHandler.setObjectAt(new Location(4,1),new WallTile(new Location(4,2)));
    }
    //moveX Funktion in +1 Richtung
    @Test
    public void moveXpTest(){

        Enemy E =new Enemy(new Location(2,2));
        LevelHandler.setObjectAt(new Location(2,2),E);

        assertNotNull(E);
        //1 Schritt
        assertTrue(E.moveX(1));
        assertInstanceOf(CoinItem.class,E.getObjectOnPosition());
        assertTrue(E.moveX(1));
        assertInstanceOf(CoinItem.class,LevelHandler.getObjectAt(E.getLocation().subtract(1,0)));
//2
        assertTrue(E.moveX(1));
        assertInstanceOf(ExtraLife.class,E.getObjectOnPosition());
        assertTrue(E.moveX(1));
        assertInstanceOf(ExtraLife.class,LevelHandler.getObjectAt(E.getLocation().subtract(1,0)));
//3
        assertTrue(E.moveX(1));
        assertInstanceOf(Key.class,E.getObjectOnPosition());
        assertTrue(E.moveX(1));
        assertInstanceOf(Key.class,LevelHandler.getObjectAt(E.getLocation().subtract(1,0)));
//4
        assertTrue(E.moveX(1));
        assertInstanceOf(Multiplier.class,E.getObjectOnPosition());
        assertTrue(E.moveX(1));
        assertInstanceOf(Multiplier.class,LevelHandler.getObjectAt(E.getLocation().subtract(1,0)));
//5
        assertTrue(E.moveX(1));
        assertInstanceOf(PowerPill.class,E.getObjectOnPosition());
        assertTrue(E.moveX(1));
        assertInstanceOf(PowerPill.class,LevelHandler.getObjectAt(E.getLocation().subtract(1,0)));
//6
        assertTrue(E.moveX(1));
        assertInstanceOf(SpeedBoots.class,E.getObjectOnPosition());
        assertTrue(E.moveX(1));
        assertInstanceOf(SpeedBoots.class,LevelHandler.getObjectAt(E.getLocation().subtract(1,0)));
//7
        assertTrue(E.moveX(1));
        assertInstanceOf(Stopwatch.class,E.getObjectOnPosition());
        assertTrue(E.moveX(1));
        assertInstanceOf(Stopwatch.class,LevelHandler.getObjectAt(E.getLocation().subtract(1,0)));
//8 Läuft in eine Wand
        assertFalse(E.moveX(1));
        assertInstanceOf(WallTile.class,LevelHandler.getObjectAt(E.getLocation().subtract(-1,0)));


        //Ende Test
        LevelHandler.setObjectAt(E.getLocation(),new EmptyTile(E.getLocation()));
    }

    //moveX Funktion in -1 Richtung
    @Test
    public void moveXnTest(){
        Enemy E =new Enemy(new Location(20,4));
        LevelHandler.setObjectAt(new Location(20,4),E);

        assertNotNull(E);
        //1 Schritt
        assertTrue(E.moveX(-1));
        assertInstanceOf(CoinItem.class,E.getObjectOnPosition());
        assertTrue(E.moveX(-1));
        assertInstanceOf(CoinItem.class,LevelHandler.getObjectAt(E.getLocation().subtract(-1,0)));
//2
        assertTrue(E.moveX(-1));
        assertInstanceOf(ExtraLife.class,E.getObjectOnPosition());
        assertTrue(E.moveX(-1));
        assertInstanceOf(ExtraLife.class,LevelHandler.getObjectAt(E.getLocation().subtract(-1,0)));
//3
        assertTrue(E.moveX(-1));
        assertInstanceOf(Key.class,E.getObjectOnPosition());
        assertTrue(E.moveX(-1));
        assertInstanceOf(Key.class,LevelHandler.getObjectAt(E.getLocation().subtract(-1,0)));
//4
        assertTrue(E.moveX(-1));
        assertInstanceOf(Multiplier.class,E.getObjectOnPosition());
        assertTrue(E.moveX(-1));
        assertInstanceOf(Multiplier.class,LevelHandler.getObjectAt(E.getLocation().subtract(-1,0)));
//5
        assertTrue(E.moveX(-1));
        assertInstanceOf(PowerPill.class,E.getObjectOnPosition());
        assertTrue(E.moveX(-1));
        assertInstanceOf(PowerPill.class,LevelHandler.getObjectAt(E.getLocation().subtract(-1,0)));
//6
        assertTrue(E.moveX(-1));
        assertInstanceOf(SpeedBoots.class,E.getObjectOnPosition());
        assertTrue(E.moveX(-1));
        assertInstanceOf(SpeedBoots.class,LevelHandler.getObjectAt(E.getLocation().subtract(-1,0)));
//7
        assertTrue(E.moveX(-1));
        assertInstanceOf(Stopwatch.class,E.getObjectOnPosition());
        assertTrue(E.moveX(-1));
        assertInstanceOf(Stopwatch.class,LevelHandler.getObjectAt(E.getLocation().subtract(-1,0)));
//8 Läuft in eine Wand
        assertFalse(E.moveX(-1));
        assertInstanceOf(WallTile.class,LevelHandler.getObjectAt(E.getLocation().subtract(+1,0)));

        //Ende Test
        LevelHandler.setObjectAt(E.getLocation(),new EmptyTile(E.getLocation()));
    }

    //moveY Funktion in +1 Richtung
    @Test
    public void moveYpTest(){
        Enemy E =new Enemy(new Location(2,0));
        LevelHandler.setObjectAt(new Location(2,0),E);

        assertNotNull(E);
        //1 Schritt
        assertTrue(E.moveY(1));
        assertInstanceOf(CoinItem.class,E.getObjectOnPosition());
        assertTrue(E.moveY(1));
        assertInstanceOf(CoinItem.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,1)));
//2
        assertTrue(E.moveY(1));
        assertInstanceOf(ExtraLife.class,E.getObjectOnPosition());
        assertTrue(E.moveY(1));
        assertInstanceOf(ExtraLife.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,1)));
//3
        assertTrue(E.moveY(1));
        assertInstanceOf(Key.class,E.getObjectOnPosition());
        assertTrue(E.moveY(1));
        assertInstanceOf(Key.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,1)));
//4
        assertTrue(E.moveY(1));
        assertInstanceOf(Multiplier.class,E.getObjectOnPosition());
        assertTrue(E.moveY(1));
        assertInstanceOf(Multiplier.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,1)));
//5
        assertTrue(E.moveY(1));
        assertInstanceOf(PowerPill.class,E.getObjectOnPosition());
        assertTrue(E.moveY(1));
        assertInstanceOf(PowerPill.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,1)));
//6
        assertTrue(E.moveY(1));
        assertInstanceOf(SpeedBoots.class,E.getObjectOnPosition());
        assertTrue(E.moveY(1));
        assertInstanceOf(SpeedBoots.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,1)));
//7 Läuft in eine Wand
        assertFalse(E.moveY(1));
        assertInstanceOf(WallTile.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,-1)));

        //Ende Test
        LevelHandler.setObjectAt(E.getLocation(),new EmptyTile(E.getLocation()));
    }

    //moveY Funktion in -1 Richtung
    @Test
    public void moveYnTest(){
        Enemy E =new Enemy(new Location(4,14));
        LevelHandler.setObjectAt(new Location(4,14),E);

        assertNotNull(E);
        //1 Schritt
        assertTrue(E.moveY(-1));
        assertInstanceOf(CoinItem.class,E.getObjectOnPosition());
        assertTrue(E.moveY(-1));
        assertInstanceOf(CoinItem.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,-1)));
//2
        assertTrue(E.moveY(-1));
        assertInstanceOf(ExtraLife.class,E.getObjectOnPosition());
        assertTrue(E.moveY(-1));
        assertInstanceOf(ExtraLife.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,-1)));
//3
        assertTrue(E.moveY(-1));
        assertInstanceOf(Key.class,E.getObjectOnPosition());
        assertTrue(E.moveY(-1));
        assertInstanceOf(Key.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,-1)));
//4
        assertTrue(E.moveY(-1));
        assertInstanceOf(Multiplier.class,E.getObjectOnPosition());
        assertTrue(E.moveY(-1));
        assertInstanceOf(Multiplier.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,-1)));
//5
        assertTrue(E.moveY(-1));
        assertInstanceOf(PowerPill.class,E.getObjectOnPosition());
        assertTrue(E.moveY(-1));
        assertInstanceOf(PowerPill.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,-1)));
//6
        assertTrue(E.moveY(-1));
        assertInstanceOf(SpeedBoots.class,E.getObjectOnPosition());
        assertTrue(E.moveY(-1));
        assertInstanceOf(SpeedBoots.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,-1)));
//7Läuft in eine Wand
        assertFalse(E.moveY(-1));
        assertInstanceOf(WallTile.class,LevelHandler.getObjectAt(E.getLocation().subtract(0,+1)));

        //Ende Test
        LevelHandler.setObjectAt(E.getLocation(),new EmptyTile(E.getLocation()));
    }

    //seePlayer Funktion
    @Test
    public void seePlayerTest(){

        Enemy E = new Enemy(new Location(12,10));
        LevelHandler.setObjectAt(E.getLocation(),E);

        //X Richtungen
        //X - Richtung
        PlayerObject P11 = new PlayerObject(new Location(1,10));
        LevelHandler.setObjectAt(P11.getLocation(),P11);
        E.setPlayer(P11.getLocation());
        assertFalse(E.seePlayer()); //False
        LevelHandler.setObjectAt(P11.getLocation(),new EmptyTile(P11.getLocation()));
        PlayerObject P12 = new PlayerObject(new Location(2,10));
        LevelHandler.setObjectAt(P12.getLocation(),P12);
        E.setPlayer(P12.getLocation());
        assertTrue(E.seePlayer());
        LevelHandler.setObjectAt(P12.getLocation(),new EmptyTile(P12.getLocation()));
        PlayerObject P13 = new PlayerObject(new Location(3,10));
        LevelHandler.setObjectAt(P13.getLocation(),P13);
        E.setPlayer(P13.getLocation());
        assertTrue(E.seePlayer());
        LevelHandler.setObjectAt(P13.getLocation(),new EmptyTile(P13.getLocation()));


        //X + Richtung
        PlayerObject P21 = new PlayerObject(new Location(21,10));
        LevelHandler.setObjectAt(P21.getLocation(),P21);
        E.setPlayer(P21.getLocation());
        assertTrue(E.seePlayer());
        LevelHandler.setObjectAt(P21.getLocation(),new EmptyTile(P21.getLocation()));
        PlayerObject P22 = new PlayerObject(new Location(22,10));
        LevelHandler.setObjectAt(P22.getLocation(),P22);
        E.setPlayer(P22.getLocation());
        assertTrue(E.seePlayer());
        LevelHandler.setObjectAt(P22.getLocation(),new EmptyTile(P22.getLocation()));
        PlayerObject P23 = new PlayerObject(new Location(23,10));
        LevelHandler.setObjectAt(P23.getLocation(),P23);
        E.setPlayer(P23.getLocation());
        assertFalse(E.seePlayer()); //False
        LevelHandler.setObjectAt(P23.getLocation(),new EmptyTile(P23.getLocation()));

        LevelHandler.setObjectAt(E.getLocation(),new EmptyTile(E.getLocation()));


        //YRichtung
        E = new Enemy(new Location(22,1));
        LevelHandler.setObjectAt(E.getLocation(),E);
        //Y - Richtung
        PlayerObject P31 = new PlayerObject(new Location(22,10));
        LevelHandler.setObjectAt(P31.getLocation(),P31);
        E.setPlayer(P31.getLocation());
        assertTrue(E.seePlayer());
        LevelHandler.setObjectAt(P31.getLocation(),new EmptyTile(P31.getLocation()));
        PlayerObject P32 = new PlayerObject(new Location(22,11));
        LevelHandler.setObjectAt(P32.getLocation(),P32);
        E.setPlayer(P32.getLocation());
        assertTrue(E.seePlayer());
        LevelHandler.setObjectAt(P32.getLocation(),new EmptyTile(P32.getLocation()));
        PlayerObject P33 = new PlayerObject(new Location(22,12));
        LevelHandler.setObjectAt(P33.getLocation(),P33);
        E.setPlayer(P33.getLocation());
        assertFalse(E.seePlayer());//False
        LevelHandler.setObjectAt(P33.getLocation(),new EmptyTile(P33.getLocation()));

        LevelHandler.setObjectAt(E.getLocation(),new EmptyTile(E.getLocation()));
        E = new Enemy(new Location(24,12));
        LevelHandler.setObjectAt(E.getLocation(),E);

        //Y + Richtung
        PlayerObject P41 = new PlayerObject(new Location(24,1));
        LevelHandler.setObjectAt(P41.getLocation(),P41);
        E.setPlayer(P41.getLocation());
        assertFalse(E.seePlayer()); //False
        LevelHandler.setObjectAt(P41.getLocation(),new EmptyTile(P41.getLocation()));
        PlayerObject P42 = new PlayerObject(new Location(24,2));
        LevelHandler.setObjectAt(P42.getLocation(),P42);
        E.setPlayer(P42.getLocation());
        assertTrue(E.seePlayer());
        LevelHandler.setObjectAt(P42.getLocation(),new EmptyTile(P42.getLocation()));
        PlayerObject P43 = new PlayerObject(new Location(24,3));
        LevelHandler.setObjectAt(P43.getLocation(),P43);
        E.setPlayer(P43.getLocation());
        assertTrue(E.seePlayer());
        LevelHandler.setObjectAt(P43.getLocation(),new EmptyTile(P43.getLocation()));

        LevelHandler.setObjectAt(E.getLocation(),new EmptyTile(E.getLocation()));
    }

    @RepeatedTest(5)
    public void resetTest(){
        Location L = new Location(12,9);
        Enemy E = new Enemy(L);

        assertNotNull(E);
        assertTrue(Location.isSame(L,E.getLocation()));
        assertTrue(E.moveX(1));
        E.reset();
        assertTrue(Location.isSame(L,E.getLocation()));

    }

    //wiederholtes Testen das gegner sich in eine richtung bewegt
    @RepeatedTest(5)
    public void moveRandom1(){
        Location L = new Location(12,9);
        Enemy E = new Enemy(L);
        LevelHandler.setObjectAt(L,E);
        E.moveRandom();
        assertTrue(!L.equals(E.getLocation()));
        LevelHandler.setObjectAt(E.getLocation(),new EmptyTile(E.getLocation()));
    }

    //Teste Verhalten Move Random mit Wänden
    @Test
    public void moveRandom2(){
        Enemy E = new Enemy(12,9);
        Location loc = E.getLocation();
        LevelHandler.setObjectAt(E.getLocation(),E);
        E.moveRandom();
        assertFalse(Location.isSame(E.getLocation(),loc));
        E.reset();

        LevelHandler.setObjectAt(new Location(11,9),new WallTile(new Location(11,9)));
        LevelHandler.setObjectAt(new Location(13,9),new WallTile(new Location(13,9)));
        LevelHandler.setObjectAt(new Location(12,8),new WallTile(new Location(12,8)));

        E.moveRandom();
        assertTrue(Location.isSame(E.getLocation(),new Location(12,10)));
        E.reset();

        LevelHandler.setObjectAt(new Location(11,9),new EmptyTile(new Location(11,9)));
        LevelHandler.setObjectAt(new Location(13,9),new EmptyTile(new Location(13,9)));
        LevelHandler.setObjectAt(new Location(12,8),new EmptyTile(new Location(12,8)));

        LevelHandler.setObjectAt(new Location(11,9),new WallTile(new Location(11,9)));
        LevelHandler.setObjectAt(new Location(13,9),new WallTile(new Location(13,9)));
        LevelHandler.setObjectAt(new Location(12,10),new WallTile(new Location(12,10)));

        E.moveRandom();
        assertTrue(Location.isSame(E.getLocation(),new Location(12,8)));
        E.reset();

        LevelHandler.setObjectAt(new Location(11,9),new EmptyTile(new Location(11,9)));
        LevelHandler.setObjectAt(new Location(13,9),new EmptyTile(new Location(13,9)));
        LevelHandler.setObjectAt(new Location(12,8),new EmptyTile(new Location(12,8)));

        LevelHandler.setObjectAt(new Location(11,9),new WallTile(new Location(11,9)));
        LevelHandler.setObjectAt(new Location(12,8),new WallTile(new Location(12,8)));
        LevelHandler.setObjectAt(new Location(12,10),new WallTile(new Location(12,10)));

        E.moveRandom();
        assertTrue(Location.isSame(E.getLocation(),new Location(13,9)));
        E.reset();

        LevelHandler.setObjectAt(new Location(11,9),new EmptyTile(new Location(11,9)));
        LevelHandler.setObjectAt(new Location(13,9),new EmptyTile(new Location(13,9)));
        LevelHandler.setObjectAt(new Location(12,8),new EmptyTile(new Location(12,8)));

        LevelHandler.setObjectAt(new Location(13,9),new WallTile(new Location(13,9)));
        LevelHandler.setObjectAt(new Location(12,8),new WallTile(new Location(12,8)));
        LevelHandler.setObjectAt(new Location(12,10),new WallTile(new Location(12,10)));

        E.moveRandom();
        assertTrue(Location.isSame(E.getLocation(),new Location(11,9)));
        E.reset();

        LevelHandler.setObjectAt(new Location(11,9),new EmptyTile(new Location(11,9)));
        LevelHandler.setObjectAt(new Location(13,9),new EmptyTile(new Location(13,9)));
        LevelHandler.setObjectAt(new Location(12,8),new EmptyTile(new Location(12,8)));
    }

    @Test
    public void move_to_positionTest(){
        Location start = new Location(12,9);
        Enemy E = new Enemy(start);
        LevelHandler.setObjectAt(E.getLocation(),E);
        Location loc1 = new Location(12,7);//y-1
        Location loc2 = new Location(12,11);//y+1
        Location loc3 = new Location(9,9);//x-1
        Location loc4 = new Location(15,9);//x+1

        E.DebuggMove_To_Position(loc1);
        assertTrue(Location.isSame(E.getLocation(),start.add(0,-1)));
        E.reset();

        E.DebuggMove_To_Position(loc2);
        assertTrue(Location.isSame(E.getLocation(),start.add(0,1)));
        E.reset();

        E.DebuggMove_To_Position(loc3);
        assertTrue(Location.isSame(E.getLocation(),start.add(-1,0)));
        E.reset();

        E.DebuggMove_To_Position(loc4);
        assertTrue(Location.isSame(E.getLocation(),start.add(1,0)));
        E.reset();
    }
}
