package client;

import java.net.Socket;
import java.util.Scanner;

public class ClientTask {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);

        System.out.println("Connection established");

        Scanner teclado = new Scanner(System.in);

        teclado.nextLine();

        socket.close();
    }
}
