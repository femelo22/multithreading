package services;

import utils.DistributeTasks;

import java.net.ServerSocket;
import java.net.Socket;

public class ServiceTask {

    public static void main(String[] args) throws Exception {

        System.out.println("---- Inicialized server ----");
        ServerSocket service = new ServerSocket(12345);

        while (true) {
            Socket socket = service.accept();
            System.out.println("Accept new client on port: " + socket.getPort());

            DistributeTasks distributeTasks = new DistributeTasks(socket);
            Thread threadClient = new Thread(distributeTasks);
            threadClient.start();
        }
    }
}
