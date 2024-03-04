public class Tile {
    //the access modifier used for them is private as I don't want them to be modified by external logic
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int adjacentMines;
    //getter and setter methods act as controlled gateways for accessing and modifying private attributes of an object
    public boolean getIsMine() {
        return isMine;
    }
    public void setMine() {
        isMine = true;
    }


    public boolean getIsRevealed() {
        return isRevealed;
    }

    public void setRevealed() {
        isRevealed = true;
    }

    public boolean getIsFlagged() {
        return isFlagged;
    }

    public void toggleFlagged() {
        isFlagged = !isFlagged;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }
    public void addAdjacentMines() {
        adjacentMines++;
    }

    public void resetTile() {
        isMine = false;
        isRevealed = false;
        adjacentMines = 0;
        isFlagged = false;
    }



    // tile state
    public String toStr() {
        if(getIsRevealed()) {
            if(getIsMine()) {
                return "M";
            } else {
                return "" + adjacentMines;
            }
        } else if(getIsFlagged()) {
            return "F";
        } else {
            return "*";
        }
    }
}
