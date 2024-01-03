package com.olegmng;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRunner {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(1300);
            Socket socket = serverSocket.accept();

            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("Hello");

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
