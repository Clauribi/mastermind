package mastermind.api.controllers;

import mastermind.api.controllers.dto.GameInput;
import mastermind.api.domain.Exceptions.GameDoesNotExistException;
import mastermind.api.domain.Exceptions.GamesDoNotExistException;
import mastermind.api.domain.Game;
import mastermind.api.domain.Exceptions.GameAlreadyExistsException;
import mastermind.api.services.GameService;
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
    private GameService gameService;

    @PostMapping("/api/games")
    public ResponseEntity<GameInput> createGame(@Valid @RequestBody GameInput gameInput) {
        try {
            gameService.addGame(gameInput);
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
            List<Game> listAllGames = gameService.allGames();
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
            Optional<Game> game = gameService.getGameById(id);
            return ResponseEntity.ok(game);
        } catch (GameDoesNotExistException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception e1) {
            return ResponseEntity.notFound().build();
        }
    }
}



