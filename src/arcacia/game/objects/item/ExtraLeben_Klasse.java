package arcacia.game.objects.item;
public class ExtraLeben_Klasse extends Item_Klasse {    //Vererbung
    boolean[] healthbar = {true,true,true};

    public boolean[] getHealthbar() {
        return healthbar;
    }
    public void setHealthbar(boolean[] healthbar) {
        this.healthbar = healthbar;
    }

    public ExtraLeben_Klasse(String name,Location extraleben,double dauer) {
        setName(name);
        setPosition(extraleben);
        setDauer(dauer);
    }

    boolean[] emptyhealthbar = {false,false,false};
    boolean[] fullhealthbar = {true,true,true};
    public void einsammeln(Object object) {
        ((ExtraLeben_Klasse) object).setPoints(getPoints() + 100);
        setEingesammelt(true);
        if(healthbar != emptyhealthbar || healthbar != fullhealthbar){
            for(int i = healthbar.length-1; i >= 0; i--){
                if(healthbar[i] == true) {
                    healthbar[i+1] = true;
                    setDauer(0);
                }
            }
        }
    }
}