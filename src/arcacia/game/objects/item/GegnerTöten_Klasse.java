package arcacia.game.objects.item;
public class GegnerTöten_Klasse extends Item {
    public GegnerTöten_Klasse(String name,Location gegnerTöten,double dauer) {
        setName(name);
        setPosition(gegnerTöten);
        setDauer(dauer);
    }
    public void einsammeln(Vector<Enemy> enemies){
        if(!isEingesammelt() && this.currentLocation.getX() == PlayerHandler.getX() && this.currentLocation.getY() == PlayerHandler.getY()) {
            Vector<Enemy> enemiesCopy = new Vector <Enemy>();
            this.setPoints(getPoints() + 100);
            setEingesammelt(true);
            double dauer = getDauer();
            while(getDauer() != 0){
                if(KeyHandler.isBewegt()){
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
            enemies = enemiesCopy;
        }
    }
}
