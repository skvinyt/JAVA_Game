package comRpg;

public class Monk extends Character {
    private int mana;

    public Monk(String name, int x, int y) {
        super(name, x, y);
        this.health = 10;
        this.strength = 1;
        this.hunger = 10;
        this.sleep = 10;
        this.age = 35;
        this.initiative = 1;
        this.mana = 10;
    }

    @Override
    public void step() {
        if (health > 0) {
            if (mana < 10) {
                mana++;
            } else {
                Character closestFriend = findClosestFriend();
                if (closestFriend != null && closestFriend.getHealth() < closestFriend.getMaxHealth()) {
                    closestFriend.setHealth(closestFriend.getHealth() + strength);
                    mana -= 2;
                } else {
                    Character closestEnemy = findClosestEnemy();
                    if (closestEnemy != null) {
                        closestEnemy.setHealth(closestEnemy.getHealth() - strength);
                        mana--;
                    }
                }
            }
        }
    }
}
