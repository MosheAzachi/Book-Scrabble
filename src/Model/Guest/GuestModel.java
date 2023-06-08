package Model.Guest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GuestModel {
    String ip;
    int port;
    String name;
    Socket guestSocket;

    public GuestModel(String ip, int port, String name) {
        this.ip = ip;
        this.port = port;
        this.name = name;
    }

    public void connectHost() {
        try {
            guestSocket = new Socket(ip, port);
            Scanner in = new Scanner(guestSocket.getInputStream());
            PrintWriter out = new PrintWriter(guestSocket.getOutputStream(),true);
            String message = "connectHost" + name;
            out.println(message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
