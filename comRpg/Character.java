package comRpg;

import java.util.List;

public abstract class Character {
    protected int health;
    protected int strength;
    protected int hunger;
    protected int sleep;
    protected int age;
    protected int initiative;
    protected Coordinates coordinates;

    public Character(String name, int x, int y) {
        this.name = name;
        this.coordinates = new Coordinates(x, y);
    }

    public abstract void step();

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public int getInitiative() {
        return initiative;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                '}';
    }

    public List<Character> getTeam() {
        if (getCoordinates().getX() == 0) {
            return leftTeam;
        } else {
            return rightTeam;
        }
    }

    public List<Character> getOpponentTeam() {
        if (getCoordinates().getX() == 0) {
            return rightTeam;
        } else {
            return leftTeam;
        }
    }

    public Character findClosestFriend() {
        Character closestFriend = null;
        double closestDistance = Double.MAX_VALUE;
        for (Character character : getTeam()) {
            if (character.getHealth() > 0 && character != this) {
                double distance = character.getCoordinates().distanceTo(getCoordinates());
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestFriend = character;
                }
            }
        }
        return closestFriend;
    }

}


