import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static final int PORT = 8189;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("server started");
            Scanner in = new Scanner(System.in);

            try (Socket socket = server.accept()) {
                System.out.println("client connected");

                DataInputStream inStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());

                Thread t1 = new Thread(() -> {
                    try {
                        while (true) {
                            String str = inStream.readUTF();
                            if (str.equals("/end")) {
                                System.out.println("Client disconnected");
                            }
                            System.out.println("Client: " + str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                t1.setDaemon(true);
                t1.start();

                while (true) {
                    String str = in.nextLine();
                    if (str.equals("/end")) {
                        System.out.println("Server stop");
                        break;
                    }
                    outStream.writeUTF(str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
