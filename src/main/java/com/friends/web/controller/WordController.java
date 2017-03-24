package com.friends.web.controller;

import com.friends.model.Words;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Liebl
 */

@Controller
@RequestMapping(value = "words")
public class WordController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> get3Words() {
        ArrayList<String> words = new ArrayList<>();
        while (words.size() < 3) {
            final String randomWord = Words.getRandomWord();
            if (!words.contains(randomWord)) {
                words.add(randomWord);
            }
        }
        return words;
    }

}
