package com.example.demo.api.controllers.dto;

import com.example.demo.api.domain.Game;
import com.example.demo.api.domain.GameStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

public class GameInput {
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

    public GameInput() {
    }

    public GameInput(int id, String reference, int numSlots, int numColors, List<String> secretCode, int maxGuesses) {
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

    public Game toDomain(){
        return new Game(this.id, this.reference, this.numSlots, this.numColors, this.secretCode, this.maxGuesses);
    }
}
