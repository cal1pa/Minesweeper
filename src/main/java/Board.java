import java.util.Random;

public class Board {
    private Tile[][] tiles;
    private int row;
    private int col;
    private int numMines;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        numMines = 0;

        tiles = new Tile[row][col];

        for(int y = 0; y < col; y++) {
            for(int x = 0; x < row; x++) {
                tiles[x][y] = new Tile();
            }
        }

    }

    public void printBoard() {
        //main grid loop
        for(int y = 0; y < col; y++) {
            for(int x = 0; x < row; x++) {
                System.out.print(tiles[x][y].toStr()+ "  ");
            }
            System.out.println(" | " + (y + 1));
        }
        //border
        for(int x = 0; x < row; x++) {
            System.out.print("_  ");
        }
        System.out.println();

        //column numbering
        for(int x = 0; x < row; x++) {
            System.out.print((x+1) + " ");
            if(x + 1 < 10) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    public void revealTile(Position position) {
        tiles[position.row][position.col].setRevealed();
    }

    public boolean validPosition(Position position) {
        return position.row >= 0 && position.col >= 0 && position.row < row && position.col < col;
    }

    public boolean isTileRevealed(Position position) {
        return tiles[position.row][position.col].getIsRevealed();
    }
    public boolean isTileMine(Position position) {
        return tiles[position.row][position.col].getIsMine();
    }

    public void addMine(Position position) {
        if(isTileMine(position)) {
            return;
        }

        int minX = Math.max(0, position.row-1);
        int maxX = Math.min(row-1, position.row+1);
        int minY = Math.max(0,position.col-1);
        int maxY = Math.min(row-1, position.col+1);
        for(int y = minY; y <= maxY; y++) {
            for(int x = minX; x <= maxX; x++) {
                tiles[x][y].addAdjacentMines();
            }
        }

        tiles[position.row][position.col].setMine();
        numMines++;

    }
    public void spawnMines(int maxMines) {
        Random rand = new Random();
        for(int i = 0; i < maxMines; i++) {
            addMine(new Position(rand.nextInt(row), rand.nextInt(col)));
        }
    }

}
