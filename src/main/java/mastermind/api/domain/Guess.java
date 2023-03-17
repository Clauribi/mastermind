package mastermind.api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity(name="guesses")
public class Guess {
    @Id
    private int idGuess;
    private List<String> code;
    private int blackPegs;
    private int whitePegs;


    public Guess() {
    }

    public Guess(List<String> code, List<Integer> feedback) {
    }

    public Guess(int idGuess, List<String> code, int blackPegs, int whitePegs) {
        this.idGuess = idGuess;
        this.code = code;
        this.blackPegs = blackPegs;
        this.whitePegs = whitePegs;
    }

    public int getIdGuess() {
        return idGuess;
    }

    public void setIdGuess(int idGuess) {
        this.idGuess = idGuess;
    }

    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }

    public int getBlackPegs() {
        return blackPegs;
    }

    public void setBlackPegs(int blackPegs) {
        this.blackPegs = blackPegs;
    }

    public int getWhitePegs() {
        return whitePegs;
    }

    public void setWhitePegs(int whitePegs) {
        this.whitePegs = whitePegs;
    }

}
