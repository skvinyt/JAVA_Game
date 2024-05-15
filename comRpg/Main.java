package comRpg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Character> leftTeam = new ArrayList<>();
        leftTeam.add(new Peasant("Вася", 0, 0));
        leftTeam.add(new Robber("Петя", 0, 1));
        leftTeam.add(new Sniper("Коля", 0, 2));


        List<Character> rightTeam = new ArrayList<>();
        rightTeam.add(new Peasant("Иван", 9, 0));
        rightTeam.add(new Robber("Александр", 9, 1));
        rightTeam.add(new Sniper("Дмитрий", 9, 2));


        List<Character> allCharacters = new ArrayList<>();
        allCharacters.addAll(leftTeam);
        allCharacters.addAll(rightTeam);

        allCharacters.sort(Comparator.comparing(Character::getInitiative).reversed());

        boolean isGameOver = false;
        while (!isGameOver) {
            for (Character character : allCharacters) {
                character.step();
                if (leftTeam.stream().allMatch(c -> c.getHealth() <= 0) ||
                        rightTeam.stream().allMatch(c -> c.getHealth() <= 0)) {
                    isGameOver = true;
                    break;
                }
            }
        }

        System.out.println("Игра закончена!");
    }
}
