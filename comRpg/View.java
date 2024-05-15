package comRpg;
import java.util.List;
public class View {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printField(List<Character> leftTeam, List<Character> rightTeam) {
        for (int y = 9; y >= 0; y--) {
            for (int x = 0; x < 10; x++) {
                Character character = getCharacterAt(x, y, leftTeam, rightTeam);
                if (character != null) {
                    System.out.print(AnsiColors.CYAN + character.getName().charAt(0) + AnsiColors.RESET);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    private static Character getCharacterAt(int x, int y, List<Character> leftTeam, List<Character> rightTeam) {
        for (Character character : leftTeam) {
            if (character.getCoordinates().getX() == x && character.getCoordinates().getY() == y) {
                return character;
            }
        }
        for (Character character : rightTeam) {
            if (character.getCoordinates().getX() == x && character.getCoordinates().getY() == y) {
                return character;
            }
        }
        return null;
    }
}
