package org.academiadecodigo.tcpchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by codecadet on 07/11/16.
 */
public class Server {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int port = 5000;
        String hostName; // = "192.168.1.14";
        String message = "";
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        ServerSocket serverSocket = null;

        try {
            System.out.println("Server - Opening Socket");
            serverSocket = new ServerSocket(port);

            clientSocket = serverSocket.accept();

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //do the actual chat
            while (true) {
                String line = in.readLine();
                System.out.println("Client: " + line);
                if (line.equals(".bye"))
                    break;
                message = input.nextLine();
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            System.out.println("Closing Connection");
            clientSocket.close();
            serverSocket.close();


        }


    }
}
