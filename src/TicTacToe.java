public class TicTacToe {
    private TicTacToeState state;

    public TicTacToe() {
        state = new TicTacToePlayingState(this);
    }
    public void setState(TicTacToeState newState) {
        state = newState;
    }

    public String getStatus() {
        return "Status: " + state.getStatus();
    }
    public void reset() {
        state.reset();
    }
    public void place(int row, int col) {
        state.place(row, col);
    }
}
