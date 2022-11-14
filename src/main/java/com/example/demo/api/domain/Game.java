package com.example.demo.api.domain;

import com.example.demo.api.domain.Exceptions.GameAlreadyFinishedException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "games")
public class Game {
    @Id
    private int id;
    @NotNull(message = "Reference is null")
    @NotBlank(message = "Reference is empty")
    private String reference;
    @Positive(message = "Number slots is negative")
    private int numSlots;
    @Positive(message = "Number colors is negative")
    private int numColors;
    @NotNull(message = "Secret code is null")
    @NotBlank(message = "Secret code is empty")
    private List<String> secretCode;
    @Positive(message = "Maximum guesses is negative")
    private int maxGuesses;
    private GameStatus status;
    private List<Colors> colors;
    private List<Guess> guesses;

    public Game() {
    }

    public Game(int id, String reference, int numSlots, int numColors, List<String> secretCode, int maxGuesses) {
        this.id = id;
        this.reference = reference;
        this.numSlots = numSlots;
        this.numColors = numColors;
        this.secretCode = secretCode;
        this.maxGuesses = maxGuesses;
        this.status = GameStatus.running;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getNumSlots() {
        return numSlots;
    }

    public void setNumSlots(int numSlots) {
        this.numSlots = numSlots;
    }

    public int getNumColors() {
        return numColors;
    }

    public void setNumColors(int numColors) {
        this.numColors = numColors;
    }

    public List<String> getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(List<String> secretCode) {
        this.secretCode = secretCode;
    }

    public int getMaxGuesses() {
        return maxGuesses;
    }

    public void setMaxGuesses(int maxGuesses) {
        this.maxGuesses = maxGuesses;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public List<Colors> getColors() {
        return colors;
    }

    public void setColors(List<Colors> colors) {
        this.colors = colors;
    }

    public List<Guess> getGuesses() {
        return guesses;
    }

    public void setGuesses(List<Guess> guesses) {
        this.guesses = guesses;
    }

    public List<Integer> feedback(List<String> code) {
//        Compares the given code with the secret code of the game, and returns a tuple
//        of the number of (black_pegs, white_pegs)

        int blackPegs = 0;
        int whitePegs = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < code.size(); i++) {
            if (code.get(i) == this.secretCode.get(i)) {
                blackPegs += 1;
            } else {
                for (int j = 0; j < this.secretCode.size(); j++) {
                    if (code.get(i).equals(this.secretCode.get(j))) {
                        whitePegs += 1;
                        break;
                    }
                }
            }
        }
        result.add(0, blackPegs);
        result.add(1, whitePegs);
        return result;

    }

    public void addGuess(List<String> code) throws GameAlreadyFinishedException {
        //      # TODO: Implement this. Call the _feedback function, and update the status of the game
        //        # depending on the result
        if (status == GameStatus.won || status == GameStatus.lost) {
            throw new GameAlreadyFinishedException("Cannot add a new guess, the game is already finished");
        } else {
            Game game = new Game();
            Guess guess = new Guess(code, game.feedback(code));
            if (maxGuesses <= 10) {
                guesses.add(guess);
                if (guess.getBlackPegs() == 4) {
                    status = GameStatus.won;
                } else {
                    status = GameStatus.running;
                }
            } else {
                status = GameStatus.lost;
            }
        }
    }
}



