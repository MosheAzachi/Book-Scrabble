package Model.Host;

import Model.Game.ClientHandler;
import Model.Game.HostServer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class GuestHandler implements ClientHandler {
    @Override
    public void handleClient(InputStream inFromclient, OutputStream outToClient) {


    }

    @Override
    public void close() {

    }
}
