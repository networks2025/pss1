import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class GopherClient {
    private static final String HOST = "gopher.mozz.us";
    private static final String PATH = "/";
    private static final int PORT = 70;

    public static void main(String[] args) {
        connect();
    }

    public static void connect() {
        try (Socket socket = new Socket(HOST, PORT);
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("✅ Successfully connected to the Gopher server at " + HOST + ":" + PORT);

            // Send the Gopher request (selector + \r\n)
            String request = PATH + "\r\n";
            outputStream.write(request.getBytes());
            outputStream.flush(); // Ensure the request is sent

            // Read and print the server response
            System.out.println("📩 Server Response:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
