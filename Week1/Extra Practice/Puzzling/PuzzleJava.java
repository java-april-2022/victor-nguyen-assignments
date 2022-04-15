// You will need to import the Random library from java.util
import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> random10 = new ArrayList<Integer>();
        Random rand = new Random ();

        for (int i=1; i<=10; i++) {
            random10.add(rand.nextInt(20) + 1);
        }

        return random10;
    }

    public String getRandomLetter() {

        Random rand = new Random();
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        char randomChar = alphabetString.charAt(rand.nextInt(26));

        return String.valueOf(randomChar);
    }

    // added alternate method with array from solutions

    public String getRandomLetterWithArray() {
        Random rand = new Random();
        
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = String.valueOf(alphabetString.charAt(i));
        }
        return alphabet[rand.nextInt(26)];
    }

    public String generatePassword() {

        String password = "";

        for(int i = 0; i < 8; i++) {
            password = password + getRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length) {

        ArrayList<String> passwordSet = new ArrayList<String>();
        for(int i = 0; i < length; i++) {
            passwordSet.add(generatePassword());
        }
        return passwordSet;

    }

    // public ArrayList<String> shuffleArray(ArrayList<String> array) {
    //     Random rand = new Random();

    //     ArrayList<String> shuffleArray = new ArrayList<String>();
    //     for(int i = 0; i < array.length(); i++) {
    //         int j = rand.nextInt(i+1);
    //         int temp = shuffleArray[i];
    //         shuffleArray[i] = shuffleArray[j];
    //         shuffleArray[j] = temp;
    //     }
    //     return shuffleArray;
    // }
}



