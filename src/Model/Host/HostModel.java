package Model.Host;

import Model.Game.Board;
import Model.Game.HostServer;
import Model.Game.Tile.Bag;
import Model.Player;

import java.util.HashMap;

public class HostModel {

    private static HostModel hostModel = null;

    private HashMap<String, Player> connectedPlayers;
    private Board board;
    private Bag bag;
    private Player hostPlayer;
    private HostServer hostServer;

    private HostModel() {
        board = Board.getBoard();
        bag = Bag.getBag();
        connectedPlayers = new HashMap<>();
    }

    public static HostModel getHost() {
        if (hostModel == null) {
            hostModel = new HostModel();
        }
        return hostModel;
    }

    //Infinity players problem need to be checked !!!
    public void setPlayer(String name) {
        hostPlayer = new Player(name);
        connectedPlayers.put(hostPlayer.getId(), hostPlayer);
    }

    public void runServer(int port) {
        hostServer = new HostServer(port, new GuestHandler());
        hostServer.start();
    }

    public HostServer getHostServer() {
        return hostServer;
    }
}
