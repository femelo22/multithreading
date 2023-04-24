package utils;

import java.net.Socket;
import java.util.Scanner;

public class DistributeTasks implements Runnable {

    private Socket socket;
    public DistributeTasks(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Distribuindo tarefas para " + socket);
            Scanner clientEntrypoint = new Scanner(socket.getInputStream());

            while (clientEntrypoint.hasNextLine()) {
                String command = clientEntrypoint.nextLine();
                System.out.println(command);
            }
            clientEntrypoint.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
