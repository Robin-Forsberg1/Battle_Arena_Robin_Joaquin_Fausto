package Test;
import Main.game.*;
import jdk.jfr.Timespan;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

    /*
    @Disabled
    @Test
    void namePlayersCanNotGivePlayerSameNameAsOtherPlayer() {
        game.giveName();
        assertFalse(game.players.get(0).getMyName().equals(game.players.get(1).getMyName()));
    }

    @Disabled
    @Test
    void namePlayersCanNotGiveComputerPlayerName() {
        game.players.add(new ComputerPlayer("Machine"));
        System.out.println(game.players.get(0).getClass());
        game.giveName();
        assertFalse(false);
    }*/
}