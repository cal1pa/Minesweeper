import java.util.Scanner;

public class Game {
    private Scanner userInput;
    public Game() {
        userInput = new Scanner(System.in);
    }
    public void start() {
        int num1, num2;
        System.out.println("Enter coordinates");
        num1 = userInput.nextInt();
        num2 = userInput.nextInt();
        System.out.println(num1 + " " + num2);
    }
}
