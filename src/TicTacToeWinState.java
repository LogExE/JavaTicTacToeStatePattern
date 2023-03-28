public class TicTacToeWinState implements TicTacToeState {
    private int who;
    private TicTacToe game;

    public TicTacToeWinState(TicTacToe game, int player) {
        this.game = game;
        who = player;
    }
    @Override
    public String getStatus() {
        return "Player " + who + " won!";
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
