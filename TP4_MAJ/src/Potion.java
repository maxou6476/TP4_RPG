public class Potion implements Consumable {


    public Potion() {

    }

}

class LifeBottle extends Potion {
    private int healthvalue;

    public LifeBottle(int healthvalue) {
        super();
        this.healthvalue = healthvalue;
    }

    public int bottleUselife() {
        return healthvalue;
    }

}

class ManaBottle extends Potion {
    private int manaValue;

    public ManaBottle(int manaValue) {
        super();
        this.manaValue = manaValue;
    }

    public int bottleUsemana() {
        return manaValue;
    }
}
