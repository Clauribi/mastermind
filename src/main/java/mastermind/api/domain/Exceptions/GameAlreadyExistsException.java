package mastermind.api.domain.Exceptions;

public class GameAlreadyExistsException extends Exception {
    public GameAlreadyExistsException(String message) {
        super(message);
    }
}
