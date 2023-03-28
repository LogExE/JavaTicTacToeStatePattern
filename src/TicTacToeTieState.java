public class TicTacToeTieState implements TicTacToeState {

    TicTacToe game;
    public TicTacToeTieState(TicTacToe game) {
        this.game = game;
    }

    @Override
    public String getStatus() {
        return "A tie!";
    }
    @Override
    public void place(int row, int col) {
        throw new GameOverPlaceException();
    }
    @Override
    public void reset() {
        game.setState(new TicTacToePlayingState(game));
    }
}
