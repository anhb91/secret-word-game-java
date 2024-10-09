import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String secretWord = "inteligence";
        int maxAttemps = 10;
        int attemps = 0;
        boolean guessedWord = false;

        char[] guessedLetters = new char[secretWord.length()];

        for (int i=0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        while(!guessedWord && attemps < maxAttemps){
            System.out.println("Word to guess: " + String.valueOf(guessedLetters) + " ( " + secretWord.length() + " letters )");
            System.out.println("type a letter please");

            char letter = Character.toLowerCase(sc.next().charAt(0));
            boolean correctLetter = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if(secretWord.charAt(i) == letter){
                    guessedLetters[i] = letter;
                    correctLetter = true;
                }
            }

            if(!correctLetter) {
                attemps++;
                System.out.println("Wrong letter! " + (maxAttemps - attemps) + " attemp(s) left.");
            }

            if(String.valueOf(guessedLetters).equals(secretWord)) {
                guessedWord = true;
                System.out.println("Congrats! you found the secret word " + secretWord);
            }
        }

        if(!guessedWord) {
            System.out.println("GAME OVER");
        }

        sc.close();
    }
}
