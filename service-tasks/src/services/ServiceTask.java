package services;

import utils.DistributeTasks;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceTask {

    public static void main(String[] args) throws Exception {

        System.out.println("---- Inicialized server ----");
        ServerSocket service = new ServerSocket(12345);
//        ExecutorService threadPool = Executors.newFixedThreadPool(2); //created pool and defined max connections
        ExecutorService threadPool = Executors.newCachedThreadPool();//created dynamic connections, close when not used

        while (true) {
            Socket socket = service.accept();
            System.out.println("Accept new client on port: " + socket.getPort());

            DistributeTasks distributeTasks = new DistributeTasks(socket); //new thread
            threadPool.execute(distributeTasks);
        }
    }
}
