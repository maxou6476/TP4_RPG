public class Enemy {
    private int lifePoints;
    private int damage;

    public Enemy(int lifePoints, int damage) {
        this.lifePoints = lifePoints;
        this.damage = damage;
    }


    public String toString() {
        return "Enemy{" +
                "lifePoints=" + lifePoints +
                ", damage=" + damage +
                '}';
    }

    public int getLifePoints()
    {
        return lifePoints;
    }

    public int attack()
    {
        return damage;
    }

}

class Boss extends Enemy {
    public Boss(int lifePoints, int damage) {
        super(lifePoints, damage);
    }
}

class BasicEnemy extends Enemy {
    public BasicEnemy(int lifePoints, int damage) {
        super(lifePoints, damage);
    }
}