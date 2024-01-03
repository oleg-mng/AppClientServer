package com.olegmng.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Client1 {

    public static void main(String[] args) throws IOException {
        final Socket client = new Socket("localhost", Server.PORT);
        // чтение
        new Thread(() -> {
            try (Scanner input = new Scanner(client.getInputStream())) {
                while (true) {
                    System.out.println(input.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Вы вышли из чата");
            }
        }).start();

        // запись
        new Thread(() -> {
            try (PrintWriter output = new PrintWriter(client.getOutputStream(), true)) {
                Scanner consoleScanner = new Scanner(System.in);
                while (true) {
                    String consoleInput = consoleScanner.nextLine();
                    output.println(consoleInput);
                    if (Objects.equals("q", consoleInput)) {
                        client.close();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Вы вышли из чата");
            }
        }).start();

    }
}


