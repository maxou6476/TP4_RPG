import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Hero {
    protected int lifePoints;
    protected int armor;
    protected int weaponDamage;
    protected int lifePointsUp;
    protected int armorUp;
    protected int weaponDamageUp;
    protected int manaPoints;
    protected List<Potion> potions = new ArrayList<>();
    protected List<Food> lembas = new ArrayList<>();


    public Hero(int lifePoints, int armor, int weaponDamage, int lifePointsUp, int armorUp, int weaponDamageUp, int manaPoints) {
        this.lifePoints = lifePoints;
        this.armor = armor;
        this.weaponDamage = weaponDamage;
        this.manaPoints = manaPoints;
        this.lifePointsUp = lifePointsUp;
        this.armorUp = armorUp;
        this.weaponDamageUp = weaponDamageUp;
    }

    public int attack() {
        return weaponDamage;
    }

    public int defense() {
        return armor;
    } // la defense diminue les degats (ce n'est pas une "attaque")

    public int getLifePoints() {
        return lifePoints;
    }

    public void takedamage(int damage) {

        lifePoints -= damage;
    }

    public String conssomablelist() {
        int lifeBottle = 0;
        int manaBottle = 0;
        int steak = 0;
        for (int i = 0; i < this.potions.size(); i++) {
            if (this.potions.get(i) instanceof ManaBottle) {
                manaBottle++;
            } else if (this.potions.get(i) instanceof LifeBottle) {
                lifeBottle++;
            }
        }
        steak = this.lembas.size();
        return "Conssomable{" +
                "Potions de vie=" + lifeBottle +
                ", Potions de Mana=" + manaBottle +
                ", steak=" + steak +
                '}';
    }

    public void consumManaPotion() {
        for (Potion potion : potions) {
            if (potion instanceof ManaBottle manaPotion) {
                manaPoints += manaPotion.bottleUsemana();
                potions.remove(manaPotion);
                break;
            }
        }
    }

}

class Hunter extends Hero {
    private int arrow;

    public Hunter(int lifePoints, int armor, int weaponDamage, int lifePointsUp, int armorUp, int weaponDamageUp, int manaPoints, int arrow) {
        super(lifePoints, armor, weaponDamage, lifePointsUp, armorUp, weaponDamageUp, manaPoints);

        this.arrow = arrow;
        for (int i = 0; i < 2; i++) {
            potions.add(new LifeBottle(30));
            potions.add(new ManaBottle(30));
            lembas.add(new Steak(30));
        }

    }

    public String toString() {
        int lifePotion = 0;
        int manaPotion = 0;
        for (int i = 0; i < potions.size(); i++) {
            if (potions.get(i) instanceof LifeBottle) {
                lifePotion++;

            } else if (potions.get(i) instanceof ManaBottle) {
                manaPotion++;
            }

        }
        return "Hunter{" +
                "lifePoints=" + lifePoints +
                ", armor=" + armor +
                ", weaponDamage=" + weaponDamage +
                ", arrow=" + arrow +
                ", Potions de vie=" + lifePotion +
                ", Potions de mana=" + manaPotion +
                ", steak=" + lembas.size() +
                '}';
    }

}

class Warrior extends Hero {
    public Warrior(int lifePoints, int armor, int weaponDamage, int manaPoints, int lifePointsUp, int armorUp, int weaponDamageUp) {
        super(lifePoints, armor, weaponDamage, manaPoints, lifePointsUp, armorUp, weaponDamageUp);

        for (int i = 0; i < 2; i++) {
            potions.add(new LifeBottle(30));
            potions.add(new ManaBottle(30));
            lembas.add(new Steak(30));
        }
    }

    public String toString() {
        int lifePotion = 0;
        int manaPotion = 0;
        for (int i = 0; i < potions.size(); i++) {
            if (potions.get(i) instanceof LifeBottle) {
                lifePotion++;

            } else if (potions.get(i) instanceof ManaBottle) {
                manaPotion++;
            }

        }
        return "Warrior{" +
                "lifePoints=" + lifePoints +
                ", armor=" + armor +
                ", weaponDamage=" + weaponDamage +
                ", Potions de vie=" + lifePotion +
                ", Potions de mana=" + manaPotion +
                ", steak=" + lembas.size() +
                '}';
    }
}

abstract class SpellCaster extends Hero {
    protected int manaPoints;

    public SpellCaster(int lifePoints, int armor, int weaponDamage, int lifePointsUp, int armorUp, int weaponDamageUp, int manaPoints) {
        super(lifePoints, armor, weaponDamage, manaPoints, lifePointsUp, armorUp, weaponDamageUp);
    }
}

class Healer extends SpellCaster {
    public Healer(int lifePoints, int armor, int weaponDamage, int lifePointsUp, int armorUp, int weaponDamageUp, int manaPoints) {
        super(lifePoints, armor, weaponDamage, lifePointsUp, armorUp, weaponDamageUp, manaPoints);

        for (int i = 0; i < 2; i++) {
            potions.add(new LifeBottle(30));
            potions.add(new ManaBottle(30));
            lembas.add(new Steak(30));
        }
    }

    public String toString() {
        int lifePotion = 0;
        int manaPotion = 0;
        for (int i = 0; i < potions.size(); i++) {
            if (potions.get(i) instanceof LifeBottle) {
                lifePotion++;

            } else if (potions.get(i) instanceof ManaBottle) {
                manaPotion++;
            }

        }
        return "Healer{" +
                "lifePoints=" + lifePoints +
                ", armor=" + armor +
                ", weaponDamage=" + weaponDamage +
                ", manaPoints=" + manaPoints +
                ", Potions de vie=" + lifePotion +
                ", Potions de mana=" + manaPotion +
                ", steak=" + lembas.size() +
                '}';
    }
}

class Mage extends SpellCaster {
    public Mage(int lifePoints, int armor, int weaponDamage, int lifePointsUp, int armorUp, int weaponDamageUp, int manaPoints) {
        super(lifePoints, armor, weaponDamage, lifePointsUp, armorUp, weaponDamageUp, manaPoints);

        for (int i = 0; i < 2; i++) {
            potions.add(new LifeBottle(30));
            potions.add(new ManaBottle(30));
            lembas.add(new Steak(30));
        }
    }

    public String toString() {
        int lifePotion = 0;
        int manaPotion = 0;
        for (int i = 0; i < potions.size(); i++) {
            if (potions.get(i) instanceof LifeBottle) {
                lifePotion++;

            } else if (potions.get(i) instanceof ManaBottle) {
                manaPotion++;
            }

        }
        return "Mage{" +
                "lifePoints=" + lifePoints +
                ", armor=" + armor +
                ", weaponDamage=" + weaponDamage +
                ", manaPoints=" + manaPoints +
                ", Potions de vie=" + lifePotion +
                ", Potions de mana=" + manaPotion +
                ", steak=" + lembas.size() +
                '}';
    }
}