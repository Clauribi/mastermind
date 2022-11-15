package com.example.demo.api.services;

import com.example.demo.api.controllers.dto.GameInput;
import com.example.demo.api.domain.Exceptions.GameAlreadyExistsException;
import com.example.demo.api.domain.Exceptions.GameDoesNotExistException;
import com.example.demo.api.domain.Exceptions.GamesDoNotExistException;
import com.example.demo.api.domain.Game;
import com.example.demo.api.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public void addGame(GameInput gameInput) throws GameAlreadyExistsException {
        if (gameRepository.existsById(gameInput.getId()))
            throw new GameAlreadyExistsException("Artist already exists.");
        Game game = gameInput.toDomain();
        gameRepository.save(game);
    }
    public List<Game> allGames() throws GamesDoNotExistException {
        List<Game> listAllGames = gameRepository.findAll();
        if (listAllGames.isEmpty()) throw new GamesDoNotExistException("Games don´t exist.");
        return listAllGames;
    }
    public Optional<Game> getGameById(int id) throws GameDoesNotExistException {
        Optional<Game> game = gameRepository.findById(id);
        if (!game.isPresent()) throw new GameDoesNotExistException("Game doesn´t exist.");
        return game;
    }



}
