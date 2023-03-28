import java.util.Arrays;

public class TicTacToePlayingState implements TicTacToeState {
    private int currentPlr;
    private char[][] field;
    private TicTacToe game;

    private int cnt;

    public TicTacToePlayingState(TicTacToe game) {
        this.game = game;
        currentPlr = 0;
        cnt = 0;
        field = new char[3][3];
        for (char[] row : field)
            Arrays.fill(row, '.');
    }
    @Override
    public String getStatus() {
        StringBuilder status = new StringBuilder();
        status.append("playing\n");
        status.append(" ---\n");
        for (char[] row : field) {
            status.append('|');
            status.append(row);
            status.append('|');
            status.append('\n');
        }
        status.append(" ---\n");
        status.append("Current player: " + currentPlr);
        return status.toString();
    }
    @Override
    public void place(int row, int col) {
        if (row < 1 || col < 1 || row > 3 || col > 3)
            throw new IllegalArgumentException("Can't place mark at that location!");
        char currentMark = currentPlr == 0 ? 'x' : 'o';
        row -= 1;
        col -= 1;
        if (field[row][col] != '.')
            throw new IllegalArgumentException("This position is already occupied!");
        field[row][col] = currentMark;
        int cntRow = 0, cntCol = 0, cntDiag = 0;
        for (int i = 0; i < 3; ++i)
            cntRow += field[row][i] == currentMark ? 1 : 0;
        for (int i = 0; i < 3; ++i)
            cntCol += field[i][col] == currentMark ? 1 : 0;
        if (row == col)
            for (int i = 0; i < 3; ++i)
                cntDiag += field[i][i] == currentMark ? 1 : 0;
        else if (row == 2 - col)
            for (int i = 0; i < 3; ++i)
                cntDiag += field[i][2 - i] == currentMark ? 1 : 0;
        if (cntRow == 3 || cntCol == 3 || cntDiag == 3)
            game.setState(new TicTacToeWinState(game, currentPlr));
        else {
            cnt += 1;
            if (cnt == 9)
                game.setState(new TicTacToeTieState(game));
            else currentPlr ^= 1;
        }
    }
    @Override
    public void reset() {
        game.setState(new TicTacToePlayingState(game));
    }
}
