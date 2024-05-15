package comRpg;

public class Sorcerer extends Character {
    private int mana;

    public Sorcerer(String name, int x, int y) {
        super(name, x, y);
        this.health = 7;
        this.strength = 4;
        this.hunger = 10;
        this.sleep = 10;
        this.age = 40;
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
                if (closestFriend != null) {
                    closestFriend.setHealth(closestFriend.getHealth() + strength);
                    mana -= 2;
                }
            }
        }
    }

}
