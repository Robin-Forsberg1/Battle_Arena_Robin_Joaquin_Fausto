package Test;
import Main.game.*;
import org.junit.jupiter.api.*;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;
    HumanPlayer human;


    @BeforeEach
    void setUp() {
        game = new Game();
    }

    //Using TDD
    @Test
    void namePlayersGivesPlayerAName() {
        game.namePlayers("Fausto");
        assertEquals("Fausto", game.players.get(0).getMyName());
    }


    @Test
    void namePlayersCanNotGivePlayerOnlySpace() {
        assertThrows(Error.class, () ->
                assertTimeoutPreemptively(Duration.ofSeconds(1), () ->
                        game.namePlayers(" ")));
    }

    @Test
    void namePlayersCanNotGivePlayerEmptySpace(){
        assertThrows(Error.class, () ->
                assertTimeoutPreemptively(Duration.ofSeconds(1), () ->
                        game.namePlayers("\n")));
    }


    @Test
    void namePlayersCanNotGivePlayerSameNameAsComputerPlayer() {
        assertThrows(Error.class, () ->
                assertTimeoutPreemptively(Duration.ofSeconds(1), () ->
                        game.namePlayers("Datorn")));
    }
}