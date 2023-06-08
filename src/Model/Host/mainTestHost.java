package Model.Host;

import Model.Game.*;
import Model.Host.HostModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mainTestHost {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        MyServer gameServer = new MyServer(8080, new BookScrabbleHandler());
        gameServer.start();

        HostModel hostModel = HostModel.getHost();
        String myName = null;
        System.out.println("Enter your name, and then press enter: ");
        try {
            myName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        hostModel.setPlayer(myName);

        hostModel.runServer(8040);


    }
}
