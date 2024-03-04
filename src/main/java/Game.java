import java.util.Scanner;

public class Game {
    private Scanner userInput;
    private Board board;
    public Game() {
        userInput = new Scanner(System.in);
        board = new Board(10,10);
    }
    public void start() {
        Position userInputPosition;
        do {
            board.printBoard();
            userInputPosition = getPositionInput();
            board.revealTile(userInputPosition);
        } while(true);
/*
        int num1, num2;
        System.out.println("Enter coordinates");
        num1 = userInput.nextInt();
        num2 = userInput.nextInt();
        System.out.println(num1 + " " + num2);
        board.printBoard();
*/
    }
    public boolean isPositionInputValid(Position position) {
        if (!board.validPosition(position)) {
            System.out.println("Invalid!");
            return false;
        }
        if(board.isTileRevealed(position)) {
            System.out.println("That cell is already revealed!");
            return false;
        }
        return true;
    }

    public Position getPositionInput() {
        Position input = new Position(0,0);
        do {
            System.out.println("Enter Coordinates (x y): ");
            if(!userInput.hasNextInt()) {
                getStringOrQuit();
                System.out.println("Invalid X coordinate.");
                continue;
            }
            input.row = userInput.nextInt();
            if(!userInput.hasNextInt()) {
                getStringOrQuit();
                System.out.println("Invalid Y coordinate.");
                continue;
            }
            input.col = userInput.nextInt();
            input.row--;
            input.col--;
        } while(!isPositionInputValid(input));
        return input;
    }

    public String getStringOrQuit() {
        String input = userInput.nextLine().trim();
        if(input.equalsIgnoreCase("quit")) {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
        return input;
    }

}
