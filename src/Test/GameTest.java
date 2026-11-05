package Test;
import Main.game.*;
import org.junit.jupiter.api.*;

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

    /*
    @Disabled
    @Test
    void namePlayersCanNotGivePlayerOnlySpaceOrEmptySpace(){
        game.giveName();
        assertTrue(game.giveName() != "\n" || game.giveName() != " ");
    }

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