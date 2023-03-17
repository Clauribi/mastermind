package mastermind.api.domain.Exceptions;

public class GameAlreadyFinishedException extends Exception{
    public GameAlreadyFinishedException(String message) {
        super(message);
    }
}
