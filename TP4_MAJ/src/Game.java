import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    List<Hero> heroes = new ArrayList<>();
    List<Potion> potions = new ArrayList<>();
    List<Food> foods = new ArrayList<>();
    List<Enemy> enemies = new ArrayList<>();
    private boolean playerTurn = true;
    private InputParser inputParser;
    private int etageCombat = 0;
    private int defaite = 0;

    public Game() {
    }

    public void playGame() {
        System.out.println("démarrage du jeu :");
        System.out.println("création de vos 4 héros : ");

        heroes.add(new Hunter(100, 3, 10, 10,0,0,0,0));
        heroes.add(new Warrior(140, 5, 10,0,0,0,0));
        heroes.add(new Mage(140, 2, 10, 0,0,0,200));
        heroes.add(new Healer(140, 2, 10, 0,0,0,200));

        while (defaite != 1) {
            etageCombat++;
            System.out.println("lancement du combat - étage " + etageCombat);
            generateCombat(etageCombat);
            upgradeHero();

        }

        System.out.println("fin du jeu");

    }

    public int generateCombat(int levelCombat) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Phase de combat");
        int choix_action;
        int choix_attaque;
        int choixConssomable;
        int vieBasicEnemy = 48 + levelCombat * 2;
        int damageBasicEnemy = 70;

        for (int i = 1; i < levelCombat + 3; i++) {
            if (i % 5 == 0) {
                enemies.add(new Boss(100, 15)); //un boss tous les 5 niveaux
            } else {
                enemies.add(new BasicEnemy(vieBasicEnemy, damageBasicEnemy)); //generation du nombre d'énemies (étage + 2)
            }
        }
        while (enemies.size() != 0) {

            System.out.println("\nétat du terrain :\nennemies :");
            for (int j = 0; j < enemies.size(); j++) {
                System.out.println(j + 1 + " - " + enemies.get(j).toString());
            }
            System.out.println("\nhero :");
            for (int j = 0; j < heroes.size(); j++) {
                System.out.println(j + 1 + " - " + heroes.get(j).toString());
            }
            System.out.println("\nà toi de jouer, que faire ?");

            for (int heroturn = 0; heroturn < heroes.size(); heroturn++) {
                System.out.println("\nhero " + (heroturn + 1) + ":\n1 - attaquer\n2 - consommable ?");
                choix_action = scanner.nextInt();
                choix_attaque = -1;
                if (choix_action == 1) {
                    System.out.println("qui attaquer ?");
                    while (choix_attaque > enemies.size() || choix_attaque < 0) {
                        choix_attaque = scanner.nextInt() - 1; //decalage de 1 pour choisir le bon enemie
                        enemies.set(choix_attaque, new Enemy(enemies.get(choix_attaque).getLifePoints() - heroes.get(heroturn).attack(), damageBasicEnemy));
                        if (enemies.get(choix_attaque).getLifePoints() <= 0) {
                            enemies.remove(choix_attaque);
                            if (enemies.size() == 0) {
                                heroturn = heroes.size();
                            }
                        }
                    }

                    System.out.println("\nennemies :");
                    for (int j = 0; j < enemies.size(); j++) {
                        System.out.println(j + 1 + " - " + enemies.get(j).toString());
                    }

                } else if (choix_action == 2) {
                    System.out.println(heroes.get(heroturn).conssomablelist());
                    System.out.println("utiliser une potions ou de la nourriture ?\n1 - potion de vie\n2 - potion de mana\n3 - steak\n4 -retour arriere");
                    choixConssomable = scanner.nextInt();
                    if (choixConssomable == 1) {
                        //System.out.println(potions.get(heroturn).bottleUse()); //marche pas mdr la fonction appelé n'est pas la bonne
                    } else if (choixConssomable == 2) {
                        //test23

                    } else if (choixConssomable == 3) {

                    } else if (choixConssomable == 4) {

                    }
                }
            }


            System.out.println("tour de l'énemies");
            for (int enemiTurn = 0; enemiTurn < enemies.size(); enemiTurn++) {
                choix_attaque = new Random().nextInt(heroes.size());
                if (heroes.get(choix_attaque) instanceof Hunter) {
                    heroes.set(choix_attaque, ((Hunter) heroes.get(choix_attaque))).takedamage(enemies.get(enemiTurn).attack());
                } else if (heroes.get(choix_attaque) instanceof Warrior) {
                    heroes.set(choix_attaque, ((Warrior) heroes.get(choix_attaque))).takedamage(enemies.get(enemiTurn).attack());
                } else if (heroes.get(choix_attaque) instanceof Mage) {
                    heroes.set(choix_attaque, ((Mage) heroes.get(choix_attaque))).takedamage(enemies.get(enemiTurn).attack());
                } else if (heroes.get(choix_attaque) instanceof Healer) {
                    heroes.set(choix_attaque, ((Healer) heroes.get(choix_attaque))).takedamage(enemies.get(enemiTurn).attack());
                }

                if (heroes.get(choix_attaque).getLifePoints() <= 0) {
                    heroes.remove(choix_attaque);
                    System.out.println("tu as perdu un hero !, il te reste (" + heroes.size() + ") hero");
                }

            }
            System.out.println("\nhero :");
            for (int j = 0; j < heroes.size(); j++) {
                System.out.println(j + 1 + " - " + heroes.get(j).toString());
            }

        }


        return 1;
    }

    public void upgradeHero() {

    }
}
