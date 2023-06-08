package Model;

import Model.Game.Tile;

import java.util.UUID;


public class Player {
    String id;
    String name;
    int score;
    Tile[] tiles;

    public Player(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
        score = 0;
        tiles = null;
    }

    public int getScore() {
        return score;
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTiles(Tile[] tiles) {
        this.tiles = tiles;
    }
}
