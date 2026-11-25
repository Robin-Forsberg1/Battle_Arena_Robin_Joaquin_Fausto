package Server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Server implements Runnable {

    private static final int PORT = 5000;

    private final MatchHistory matchHistory = new MatchHistory();

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                // Handle each connection in its own thread
                Thread clientThread = new Thread(
                        () -> handleClient(clientSocket)
                );

                clientThread.start();
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    // Handles communication with an individual client
    private void handleClient(Socket socket) {
        try (
                Socket clientSocket = socket;
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream(),
                                StandardCharsets.UTF_8
                        )
                );
                PrintWriter output = new PrintWriter(
                        clientSocket.getOutputStream(),
                        true
                )
        ) {

            String command = input.readLine();

            if ("SAVE".equals(command)) {

                String result = input.readLine();

                if (result != null) {
                    matchHistory.saveMatch(result);
                    output.println("OK");
                } else {
                    output.println("ERROR: Missing match result");
                }

            } else if ("HISTORY".equals(command)) {

                List<String> history = matchHistory.readHistory();

                // First send the number of records
                output.println(history.size());

                // Then send each record
                for (String match : history) {
                    output.println(match);
                }

            } else {
                output.println("ERROR: Unknown command");
            }

        } catch (IOException e) {
            System.out.println("Client communication error: " + e.getMessage());
        }
    }
}