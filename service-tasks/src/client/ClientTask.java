package client;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTask {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);

        System.out.println("Connection established");

        PrintStream output = new PrintStream(socket.getOutputStream());
        output.println("c1");

        Scanner keyboard = new Scanner(System.in);

        keyboard.nextLine();

        output.close();
        keyboard.close();
        socket.close();
    }
}
