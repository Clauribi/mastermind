package com.example.demo.api.controllers;

import com.example.demo.api.controllers.dto.GameInput;
import com.example.demo.api.controllers.dto.GuessInput;
import com.example.demo.api.domain.Exceptions.GameDoesNotExistException;
import com.example.demo.api.domain.Exceptions.GamesDoNotExistException;
import com.example.demo.api.domain.Game;
import com.example.demo.api.domain.Exceptions.GameAlreadyExistsException;
import com.example.demo.api.domain.Guess;
import com.example.demo.api.repositories.GameRepository;
import com.example.demo.api.repositories.GuessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @PostMapping("/api/games")
    public ResponseEntity<GameInput> createGame(@Valid @RequestBody GameInput gameInput) {
        try {
            if (gameRepository.existsById(gameInput.getId()))
                throw new GameAlreadyExistsException("Artist already exists.");
            Game game = gameInput.toDomain();
            gameRepository.save(game);
        } catch (GameAlreadyExistsException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        } catch (Exception e1) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/api/games")
    public ResponseEntity<List<Game>> allGames() {
        try {
            List<Game> listAllGames = gameRepository.findAll();
            if (listAllGames.isEmpty()) throw new GamesDoNotExistException("Games don´t exist.");
            return ResponseEntity.ok(listAllGames);
        } catch (GamesDoNotExistException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception e1) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/games/{id}")
    public ResponseEntity<Optional<Game>> getGameById(@PathVariable int id) {
        try {
            Optional<Game> game = gameRepository.findById(id);
            if (!game.isPresent()) throw new GameDoesNotExistException("Game doesn´t exist.");
            return ResponseEntity.ok(game);
        } catch (GameDoesNotExistException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception e1) {
            return ResponseEntity.notFound().build();
        }
    }
}



