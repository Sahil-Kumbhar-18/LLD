interface Charger{
    void Charge();
}

class OldCharger{
    public void OldCharging(){
        System.out.println("Charging Using Old Charger");
    }
}

class AdapterCharger implements Charger{
    OldCharger charger;
    AdapterCharger(OldCharger charger){
        this.charger=charger;
    }
    public void Charge(){
        charger.OldCharging();
    }
}

public class Adapter{
    
     public static void main(String[] args) {
        OldCharger charger=new OldCharger();
        Charger charge=new AdapterCharger(charger);
        charge.Charge();
     }
}