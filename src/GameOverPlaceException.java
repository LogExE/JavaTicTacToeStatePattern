public class GameOverPlaceException extends IllegalStateException {
    public GameOverPlaceException() {
        super("You can't place mark. The game is over!");
    }
}
