package utils;

import services.ServiceTask;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistributeTasks implements Runnable {

    private Socket socket;
    private ServiceTask serviceTask;

    public DistributeTasks(Socket socket, ServiceTask serviceTask) {
        this.socket = socket;
        this.serviceTask = serviceTask;
    }

    @Override
    public void run() {
        try {
            System.out.println("Distribuindo tarefas para " + socket);
            Scanner clientEntrypoint = new Scanner(socket.getInputStream());

            PrintStream outputClient = new PrintStream(socket.getOutputStream());

            while (clientEntrypoint.hasNextLine()) {
                String command = clientEntrypoint.nextLine();

                switch (command) {
                    case "c1":
                        System.out.println("Received c1 command");
                        break;
                    case "c2":
                        System.out.println("Received c2 command");
                        break;
                    case "end":
                        System.out.println("Down server");
                        serviceTask.stopServer();
                        break;
                    default:
                        System.out.println("Received " + command + " command");
                        break;
                }

                System.out.println(command);
            }

            outputClient.close();
            clientEntrypoint.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
