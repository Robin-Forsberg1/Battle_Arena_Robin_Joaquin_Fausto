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
    void nameYourselfGivesPlayerAName() {
        game.nameYourself("Fausto");
        assertEquals("Fausto", game.players.get(0).getMyName());
    }


    @Test
    void nameYourselfCanNotGivePlayerOnlySpace() {
        assertThrows(Error.class, () ->
                assertTimeoutPreemptively(Duration.ofSeconds(1), () ->
                        game.nameYourself(" ")));
    }

    @Test
    void nameYourselfCanNotGivePlayerEmptySpace(){
        assertThrows(Error.class, () ->
                assertTimeoutPreemptively(Duration.ofSeconds(1), () ->
                        game.nameYourself("\n")));
    }


    @Test
    void nameYourselfCanNotGivePlayerSameNameAsComputerPlayer() {
        assertThrows(Error.class, () ->
                assertTimeoutPreemptively(Duration.ofSeconds(1), () ->
                        game.nameYourself("Datorn")));
    }
}