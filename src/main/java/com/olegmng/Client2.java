package com.olegmng;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket client = new Socket(address, 1300);

            System.out.println(client.getLocalPort());
            System.out.println(client.getInetAddress());

            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            DataInputStream dataInStream = new DataInputStream(inStream);
            PrintStream printStream = new PrintStream(outStream);

            printStream.println("Hi!");
            System.out.println(dataInStream.readLine());

            client.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
