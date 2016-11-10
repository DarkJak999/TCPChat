package org.academiadecodigo.tcpchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by codecadet on 07/11/16.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int port = 5000;
        String hostName = "localhost";
        String line = "";


        /*
        System.out.println("Input the Host Name");
        hostName = input.nextLine();

        System.out.println("Input the port for the connection");
        port = input.nextInt();
        input.nextLine();
        */

        System.out.println("Opening Socket");

        Socket clientSocket = new Socket(hostName, port);


        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        while(true) {
            line = input.nextLine();
            out.println(line);
            if(line.equals(".bye"))
                break;
            System.out.println("Server: " + in.readLine());
        }

        in.close();
        out.close();
        clientSocket.close();


    }
}
