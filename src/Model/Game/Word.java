package Model.Game;

import java.util.Arrays;

public class Word {
    private Tile[] tiles;
    private int row;
    private int col;
    private boolean vertical;

    
    public Word(Tile[] tiles, int row, int col, boolean vertical) {
        this.tiles = new Tile[tiles.length];
        for (int i = 0; i < tiles.length; i++)
        {
            this.tiles[i] = tiles[i];
        }
        this.row = row;
        this.col = col;
        this.vertical = vertical;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Word other = (Word) obj;
        if (!Arrays.equals(tiles, other.tiles))
            return false;
        if (row != other.row)
            return false;
        if (col != other.col)
            return false;
        if (vertical != other.vertical)
            return false;
        return true;
    }

    public Tile[] getTiles() {
        return tiles;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public boolean isVertical() {
        return vertical;
    }
}
