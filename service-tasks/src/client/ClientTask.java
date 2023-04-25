package client;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTask {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);

        System.out.println("Connection established");

        Thread threadSendCommand = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PrintStream output = new PrintStream(socket.getOutputStream());
                    Scanner keyboard = new Scanner(System.in);
                    while(keyboard.hasNextLine()) {
                        String line = keyboard.nextLine();

                        if(line.trim().equals("")) {
                            break;
                        }

                        output.println(line);
                    }

                    output.close();
                    keyboard.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadReceiveResponse = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Received server data");
                    Scanner responseServer = new Scanner(socket.getInputStream());

                    while (responseServer.hasNextLine()) {
                        String line = responseServer.nextLine();
                        System.out.println(line);
                    }

                    responseServer.close();


                }catch (Exception e) {

                }
            }
        });

        threadSendCommand.start();
        threadReceiveResponse.start();

        threadSendCommand.join(); //thread main wait this thread finished

        System.out.println("Close client socket");
        socket.close();
    }
}
