public class Board {
    private Tile[][] tiles;
    private int row;
    private int col;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;

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



}
