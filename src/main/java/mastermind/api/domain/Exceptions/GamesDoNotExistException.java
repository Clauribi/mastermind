package mastermind.api.domain.Exceptions;

public class GamesDoNotExistException extends Exception{
    public GamesDoNotExistException(String message) {
        super(message);
    }
}
