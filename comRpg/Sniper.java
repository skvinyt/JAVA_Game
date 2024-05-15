package comRpg;

public class Sniper extends Character {
    private int arrows;

    public Sniper(String name, int x, int y) {
        super(name, x, y);
        this.health = 8;
        this.strength = 3;
        this.hunger = 10;
        this.sleep = 10;
        this.age = 30;
        this.initiative = 3;
        this.arrows = 10;
    }

    @Override
    public void step() {
        if (health > 0) {
            Character closestEnemy = findClosestEnemy();
            if (closestEnemy != null) {
                closestEnemy.setHealth(closestEnemy.getHealth() - strength * 2);
            }
        }
    }

}
