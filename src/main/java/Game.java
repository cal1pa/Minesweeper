import java.util.Scanner;

public class Game {
    private Scanner userInput;
    private Board board;
    public Game() {
        userInput = new Scanner(System.in);
        board = new Board(3,3);
        board.spawnMines(2);
    }
    public void start() {
        boolean isFlagging;
        Position userInputPosition;
        do {
            board.status();
            board.printBoard();
            userInputPosition = getPositionInput();
            isFlagging = getStringOrQuit().equalsIgnoreCase("flag");
            if(isFlagging) {
                board.flagTile(userInputPosition);
            } else if(board.isTileFlagged(userInputPosition)) {
                System.out.println("You need to undo the flag first.");
            } else {
                board.revealTile(userInputPosition);
            }
        } while(!board.isWon() && (isFlagging || !board.isTileMine(userInputPosition)));
        board.revealAll();
        board.printBoard();
        if(board.isWon()) {
            System.out.println("You win");
        } else {
            System.out.println("Oh no! A bomb");
        }

    }
    public boolean isPositionInputValid(Position position) {
        if (!board.validPosition(position)) {
            System.out.println("Invalid coordinate!");
            return false;
        } else if(board.isTileRevealed(position)) {
            System.out.println("That cell is already revealed!");
            return false;
        } else {
            return true;
        }
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
