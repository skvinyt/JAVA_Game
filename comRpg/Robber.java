package comRpg;

public class Robber extends Character {
    public Robber(String name, int x, int y) {
        super(name, x, y);
        this.health = 10;
        this.strength = 2;
        this.hunger = 10;
        this.sleep = 10;
        this.age = 25;
        this.initiative = 1;
    }

    @Override
    public void step() {
        if (health > 0) {
            Character closestEnemy = findClosestEnemy();
            if (closestEnemy != null) {
                closestEnemy.setHealth(closestEnemy.getHealth() - strength);
            }
        }
    }

}
