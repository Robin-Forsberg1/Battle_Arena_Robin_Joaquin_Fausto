package Server;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Server implements Runnable {

    private static final int PORT = 5000;

    private final MatchHistory matchHistory = new MatchHistory();

    @Override
    public void run() {
        // Starts the server and handles incoming client connections
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(
                        () -> handleClient(clientSocket)
                );

                clientThread.start();
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
    //Handles client requests to save match results or retrieve match history
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
                        true)) {

            String command = input.readLine();

        //Saves a match result received from the client
            if ("SAVE".equals(command)) {

                String result = input.readLine();

                if (result != null) {
                    matchHistory.saveMatch(result);
                    output.println("OK");
                } else {
                    output.println("ERROR: Missing match result");
                }

                //sends the saved match history to the client
            } else if ("HISTORY".equals(command)) {

                List<String> history = matchHistory.readHistory();

                output.println(history.size());

                for (String match : history) {
                    output.println(match);
                }

            //Responds to commands that the server does not recognize
            } else {
                output.println("ERROR: Unknown command");
            }

        } catch (IOException e) {
            System.out.println("Client communication error: " + e.getMessage());
        }
    }
}



