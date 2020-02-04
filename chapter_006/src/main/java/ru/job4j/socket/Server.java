package ru.job4j.socket;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        try {
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String ask;
            do {
                System.out.println("Ждем команд...");
                ask = in.readLine();
                System.out.println(ask);
                if ("привет".equals(ask)) {
                    out.println("Привет, я Оракл!");
                    out.println();
                } else if (!("пока".equals(ask))) {
                    out.println("Ну этого я не понимаю...");
                    out.println();
                } else {
                    out.print("");
                }
            } while ((!("пока".equals(ask))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
