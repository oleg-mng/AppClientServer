package com.olegmng;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket socket = new Socket(address, 1300);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
