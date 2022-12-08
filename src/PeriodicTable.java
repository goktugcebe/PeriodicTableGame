import java.util.*;
import java.util.HashMap;
import java.util.Map;

/**
 *  This class contains the required component of our Periodic Table game.
 *  @author goktugcebe
 *  @version 0.0.0.1
 */
public class PeriodicTable {

    /**
     * This method is the core method for our program. Inside this method HashMap is created and elements added.
     * Then the method is compare the String values which we got from user with the elements of hashMap.
     * Finally, method brings the variable result of game to the user.
     */
    public void getTable() {

        Map<String, String> hMap = new HashMap<>();

        hMap.put("Hydrogen", "H");
        hMap.put("Helium", "He");
        hMap.put("Lithium", "Li");
        hMap.put("Beryllium", "Be");
        hMap.put("Boro", "B");
        hMap.put("Carbon", "C");
        hMap.put("Nitrogen", "N");
        hMap.put("Oxygen", "O");
        hMap.put("Fluorine", "F");
        hMap.put("Neon", "Ne");

        Scanner scanner = new Scanner(System.in);
        int attempt = 3;
        System.out.println(welcomeMessage(attempt));
        Collection<String> values=hMap.values();
        for (String value : values) {
            System.out.print(value+"\t");
        }
        System.out.println();
        Set<String> set = hMap.keySet();
        Iterator it = set.iterator();

        int totalScore = 0;
        int correctAnswer=0;
        int wrongAnswer=0;

        while (it.hasNext()) {
            for (String set3 : set) {
                String symbol = hMap.get(it.next());
                System.out.println("===================\n"+"Please enter the name of corresponding element to the symbol : " + symbol);
                String element = scanner.nextLine();

                if (element.equalsIgnoreCase(set3)) {
                    System.out.println("===================\n" + "Your guess is correct! You have got! +10 point ");
                    totalScore += 10;
                    correctAnswer++;
                    System.out.println("Your total score is : " + totalScore);

                } else if (!element.equalsIgnoreCase(set3)) {
                    attempt -= 1;
                    System.out.println("===================\n" + "Your guess is wrong! You have lost -5 point! " + attempt + " attempt left!");
                    totalScore -= 5;
                    wrongAnswer++;
                    System.out.println("Your total score is : " + totalScore);
                    if (attempt == 0) {
                        System.out.println("===================\n" + "Game is over! You have lost your all chances!");
                        System.out.println(finalMessage(totalScore,correctAnswer,wrongAnswer));
                        break;
                    }
                }
            }
            if (!it.hasNext()) {
                System.out.println("===================");
                System.out.println("Congratulations, you got all the elements right!");
                System.out.println(finalMessage(totalScore,correctAnswer,wrongAnswer));
                break;
            }
        }
    }

    /**
     *This method is used to monitor String welcome message to user and
     *  all elements from our limited periodic table.
     * @param attempt gives to user to chance to move on game
     * @return message which is welcome message for users
     */
    private String welcomeMessage(int attempt){
        String message = "===================\n" +
                "Welcome to Periodic Table Game\n" +
                "You have only " + attempt + " right to guess the correct element!\n" +
                "The game has been started. Good luck!\n"+
                "------------------\n"+
                "Here is our limited Periodic Table: ";
        return message;
    }

    /**
     * This method is used to monitor String message to user end of game.
     * @param totalScore
     * @param correctAnswer
     * @param wrongAnswer
     * @return finalMessage which is used to monitor at end of the games.
     */

    private String finalMessage(int totalScore,int correctAnswer,int wrongAnswer){
        String finalMessage="Your total score is : " + totalScore+
                "\nNumber of correct guesses: "+correctAnswer+
                "\nNumber of wrong guesses: "+wrongAnswer;
        return finalMessage;
    }

}
