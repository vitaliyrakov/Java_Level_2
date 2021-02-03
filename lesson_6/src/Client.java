import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static final int PORT = 8189;
    static final String SERVER = "localhost";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try (Socket socket = new Socket(SERVER, PORT)) {
            System.out.println("connected");
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());

            Thread t1 = new Thread(() -> {
                try {
                    while (true) {
                        String str = inStream.readUTF();
                        System.out.println("Server: " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t1.setDaemon(true);
            t1.start();

            while (true) {
                String str = in.nextLine();
                outStream.writeUTF(str);
                if (str.equals("/end")) {
                    System.out.println("disconnected");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
