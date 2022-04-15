import java.util.ArrayList;
import java.util.Random;

public class TestPuzzle {
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
		String randomLetters = generator.getRandomLetter();
		System.out.println(randomLetters);

		String randomPassword = generator.generatePassword();
		System.out.println(randomPassword);

		ArrayList<String> randomPasswordLength = generator.getNewPasswordSet(10);
		System.out.println(randomPasswordLength);

		// Sensei Bonus - play around with later
		
		// ArrayList<String> shuffleArray = generator.getNewPasswordSet(3);
		// System.out.println(shuffleArray);
		// ArrayList<String> shuffledArray = generator.shuffleArray(shuffleArray);
		// System.out.println(shuffledArray);
	}
}
