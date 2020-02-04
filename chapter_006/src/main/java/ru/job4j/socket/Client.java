package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        try {
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            do {
                out.println(userInput.readLine());
                String str;
                do {
                    str = in.readLine();
                    if (!str.isEmpty()) {
                        System.out.println("Сервер вернул: " + str);
                    }
                }
                while (!str.isEmpty());
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 5000)) {
            new Client(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
