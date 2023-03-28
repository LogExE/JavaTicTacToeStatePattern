public class TicTacToeTieState implements TicTacToeState {

    TicTacToe game;
    public TicTacToeTieState(TicTacToe game) {
        this.game = game;
    }

    public String getStatus() {
        return "A tie!";
    }
    public void place(int row, int col) {
        throw new GameOverPlaceException();
    }

    public void reset() {
        game.setState(new TicTacToePlayingState(game));
    }
}
