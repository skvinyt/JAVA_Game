package comRpg;

public class Peasant extends Character {
    private int arrows;

    public Peasant(String name, int x, int y) {
        super(name, x, y);
        this.health = 10;
        this.strength = 1;
        this.hunger = 10;
        this.sleep = 10;
        this.age = 20;
        this.initiative = 0;
        this.arrows = 1;
    }

    @Override
    public void step() {
        if (health > 0 && arrows > 0) {
            for (Character character : getTeam()) {
                if (character instanceof Archer && character.getHealth() > 0 && ((Archer) character).getArrows() < 10) {
                    ((Archer) character).setArrows(((Archer) character).getArrows() + 1);
                    setArrows(getArrows() - 1);
                    break;
                }
            }
        }   
 
    }

}
