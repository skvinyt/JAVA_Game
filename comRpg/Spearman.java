package comRpg;

public class Spearman extends Character {
    public Spearman(String name, int x, int y) {
        super(name, x, y);
        this.health = 12;
        this.strength = 2;
        this.hunger = 10;
        this.sleep = 10;
        this.age = 22;
        this.initiative = 2;
    }

    @Override
    public void step() {
        if (health > 0) {
            Character closestEnemy = findClosestEnemy();
            if (closestEnemy != null) {
                closestEnemy.setHealth(closestEnemy.getHealth() - strength);
                int distanceX = Math.abs(closestEnemy.getCoordinates().getX() - getCoordinates().getX());
                int distanceY = Math.abs(closestEnemy.getCoordinates().getY() - getCoordinates().getY());
                if (distanceX > distanceY) {
                    if (closestEnemy.getCoordinates().getX() > getCoordinates().getX()) {
                        getCoordinates().setX(getCoordinates().getX() + 1);
                    } else {
                        getCoordinates().setX(getCoordinates().getX() - 1);
                    }
                } else {
                    if (closestEnemy.getCoordinates().getY() > getCoordinates().getY()) {
                        getCoordinates().setY(getCoordinates().getY() + 1);
                    } else {
                        getCoordinates().setY(getCoordinates().getY() - 1);
                    }
                }
            }
        }
    }
}

