import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTest {
    TicTacToe game;

    String firstStepStatus = """
                Status: playing
                 ---
                |...|
                |...|
                |...|
                 ---
                Current player: 0""";

    @BeforeEach
    void setGame() {
        game = new TicTacToe();
    }

    @Test
    @DisplayName("Initial state check")
    void gameStartTest() {
        assertEquals(game.getStatus(), firstStepStatus);
    }

    @Test
    @DisplayName("Wrong placement throw")
    void wrongPlace() {
        assertThrows(IllegalArgumentException.class, () -> game.place(1, 4));
    }

    @Test
    @DisplayName("Same spot throw")
    void samePlace() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.place(1, 3);
            game.place(1, 3);
        });
    }

    void makeZerothPlayerWin() {
        // Первый игрок закрывает диагональ
        game.place(1, 1);
        game.place(1, 2);
        game.place(2, 2);
        game.place(1, 3);
        game.place(3, 3);
    }

    void makeTie() {
        game.place(1, 1);
        game.place(2, 2);
        game.place(1, 2);
        game.place(1, 3);
        game.place(3, 1);
        game.place(2, 1);
        game.place(2, 3);
        game.place(3, 2);
        game.place(3, 3);
    }

    @Test
    @DisplayName("Win condition")
    void winStatus() {
        makeZerothPlayerWin();
        assertEquals(game.getStatus(), "Status: Player 0 won!");
    }

    @Test
    @DisplayName("Tie condition")
    void tieStatus() {
        // Ничья
        makeTie();
        assertEquals(game.getStatus(), "Status: A tie!");
    }

    @Test
    @DisplayName("Win status GameOverException")
    void gameIsOverAfterWin() {
        makeZerothPlayerWin();
        assertThrows(GameOverPlaceException.class, () -> game.place(1, 1));
    }

    @Test
    @DisplayName("Tie status GameOverException")
    void gameIsOverAfterTie() {
        makeTie();
        assertThrows(GameOverPlaceException.class, () -> game.place(1, 1));
    }

    @Test
    @DisplayName("Win reset check")
    void resetAfterWin() {
        makeZerothPlayerWin();
        game.reset();
        assertEquals(game.getStatus(), firstStepStatus);
    }
}
