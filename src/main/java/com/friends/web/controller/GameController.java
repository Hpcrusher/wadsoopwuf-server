package com.friends.web.controller;

import com.friends.model.Game;
import com.friends.model.User;
import com.friends.repository.GameRepository;
import com.friends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author David Liebl
 */

@Controller
@RequestMapping(value = "games")
public class GameController {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    @Autowired
    public GameController(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void newGame() {
        final Game game = new Game();
        gameRepository.save(game);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> getGamesAsJson(@RequestParam String id) {
        final User user = userRepository.findOne(UUID.fromString(id));
        return gameRepository.findAll();
    }

}
