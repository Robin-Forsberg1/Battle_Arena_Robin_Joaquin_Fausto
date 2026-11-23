package Server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MatchHistory {

    private final Path historyFile = Path.of("matchHistory.txt");

    public synchronized void saveMatch(String result) throws IOException {
        Files.writeString(
                historyFile,
                result + System.lineSeparator(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }

    public List<String> readHistory() throws IOException {
        if (!Files.exists(historyFile)) {
            return List.of();
        }

        return Files.readAllLines(historyFile);
    }
}