package services;

import utils.DistributeTasks;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceTask {

    private ExecutorService threadPool;
    private ServerSocket server;
    private boolean isRunning;

    public ServiceTask() throws Exception {
        System.out.println("---- Inicialized server ----");
        this.server = new ServerSocket(12345);
        this.threadPool = Executors.newCachedThreadPool();
        this.isRunning = true;
    }

    public void runServer() throws Exception {
        while (this.isRunning) {
            try {
                Socket socket = server.accept();
                System.out.println("Accept new client on port: " + socket.getPort());
                DistributeTasks distributeTasks = new DistributeTasks(socket, this); //new thread
                threadPool.execute(distributeTasks);
            } catch (SocketException ex) {
                System.out.println("SocketException, running? " + this.isRunning);
            }
        }
    }

    public void stopServer() throws Exception {
        isRunning = false;
        server.close();
        threadPool.shutdown();
    }

    public static void main(String[] args) throws Exception {
        ServiceTask serviceTask = new ServiceTask();
        serviceTask.runServer();
        serviceTask.stopServer();
    }
}
