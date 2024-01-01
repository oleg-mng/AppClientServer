package com.olegmng;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRunner {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(1300);
            Socket socket = serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
