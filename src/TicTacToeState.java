public interface TicTacToeState {
    String getStatus();
    void place(int row, int col);

    void reset();
}
