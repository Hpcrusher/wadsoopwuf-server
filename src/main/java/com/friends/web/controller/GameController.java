package com.friends.web.controller;

import com.friends.model.Game;
import com.friends.model.User;
import com.friends.repository.GameRepository;
import com.friends.repository.UserRepository;
import com.friends.web.model.GameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public void newGame(@RequestBody GameDto dto) {
        Game game = new Game();
        User userA = userRepository.findByUsername(dto.userA.username);
        User userB = userRepository.findByUsername(dto.userB.username);
        if (userA == null || userB == null) {
            return;
        }
        game.setUserA(userA);
        game.setUserB(userB);
        game.setWord(dto.word);
        game.setPicture(dto.picture);
        game.setUserAIsDrawing(false);
        gameRepository.save(game);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> getGamesAsJson(@RequestParam String id) {
        final User user = userRepository.findOne(UUID.fromString(id));
        List<Game> listOne = gameRepository.findByUserAAndUserAIsDrawing(user, true);
        List<Game> listTwo = gameRepository.findByUserBAndUserAIsDrawing(user, false);

        return Stream.concat(listOne.stream(), listTwo.stream()).collect(Collectors.toList());
    }

    @RequestMapping(value = "{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateGame(@PathVariable UUID id, @RequestBody GameDto dto) {
        Game game = gameRepository.findOne(id);
        if (game == null) {
            return;
        }
        //TODO
        gameRepository.save(game);
    }

}
