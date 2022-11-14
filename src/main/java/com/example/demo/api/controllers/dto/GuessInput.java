package com.example.demo.api.controllers.dto;

import com.example.demo.api.domain.Guess;

import java.util.List;

public class GuessInput {
    private int idGuess;
    private List<String> code;
    private int blackPegs;
    private int whitePegs;
    private int idGame;

    public GuessInput() {
    }

    public GuessInput(int idGuess, List<String> code, int blackPegs, int whitePegs, int idGame) {
        this.idGuess = idGuess;
        this.code = code;
        this.blackPegs = blackPegs;
        this.whitePegs = whitePegs;
        this.idGame = idGame;
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

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public Guess toDomain() {
        return new Guess(this.idGuess, this.code, this.blackPegs, this.whitePegs);
    }
}
