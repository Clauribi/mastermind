package mastermind.api.domain.Exceptions;

public class GameDoesNotExistException extends Exception {
    public GameDoesNotExistException(String message) {
        super(message);
    }
}
