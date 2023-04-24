package utils;

import java.net.Socket;

public class DistributeTasks implements Runnable {

    private Socket socket;
    public DistributeTasks(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Distribuindo tarefas para " + socket);

        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
