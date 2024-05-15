package comRpg;

public class Archer extends Character {
    private int arrows;

    public Archer(String name, int x, int y) {
        super(name, x, y);
        this.health = 9;
        this.strength = 2;
        this.hunger = 10;
        this.sleep = 10;
        this.age = 28;
        this.initiative = 3;
        this.arrows = 10;
    }

    @Override
    public void step() {
        if (health > 0 && arrows > 0) {
            Character closestEnemy = findClosestEnemy();
            if (closestEnemy != null) {
                closestEnemy.setHealth(closestEnemy.getHealth() - strength);
                setArrows(getArrows() - 1);
            }
        }
    }

    private Character findClosestEnemy() {
        Character closestEnemy = null;
        double closestDistance = Double.MAX_VALUE;
        for (Character character : getOpponentTeam()) {
            if (character.getHealth() > 0) {
                double distance = character.getCoordinates().distanceTo(getCoordinates());
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestEnemy = character;
                }
            }
        }
        return closestEnemy;
    }

}
