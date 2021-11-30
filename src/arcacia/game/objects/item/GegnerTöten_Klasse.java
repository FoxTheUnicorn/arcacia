package arcacia.game.objects.item;
public class GegnerTöten_Klasse extends Item_Klasse {
    public GegnerTöten_Klasse(String name,Location gegnerTöten,double dauer) {
        setName(name);
        setPosition(gegnerTöten);
        setDauer(dauer);
    }
    public void einsammeln(Object object, Vector<Enemy> enemies, KeyHandler handler){
        Vector<Enemy> enemiesCopy = new Vector <Enemy>();
        ((GegnerTöten_Klasse) object).setPoints(getPoints() + 100);
        setEingesammelt(true);
        double dauer = getDauer();
       // if(getEingesammelt()){
            while(getDauer() != 0){
                if(handler.isBewegt()){
                    setDauer(dauer--);
                    for(int i = 0; i < enemies.size(); i++){
                        if(Location.isSame(enemies.get(i).currentLocation, enemies.get(i).getSpieler)){
                            enemiesCopy.add(i,enemies.get(i));
                            enemies.get(i) = null;
                            enemies.remove(i);
                            setPoints(getPoints()+100);
                        }
                    }
                }
            }
        //}
        enemies = enemiesCopy;
    }
}
