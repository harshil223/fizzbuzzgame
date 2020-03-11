package game.fizzbuzz.controller;

import game.fizzbuzz.service.FizzBuzzGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Harshil Mehta

@RestController
public class FizzBuzzGame {

    @Autowired
    private FizzBuzzGameService fizzBuzzGameService;

    @RequestMapping(value = "/fizzbuzz/{numberString}", produces = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> playTheGame(@PathVariable(value = "numberString") String numberString) {
        Integer number;
        try {
            number = Integer.parseInt(numberString);
            return ResponseEntity.ok(fizzBuzzGameService.play(number));
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Not a number");
        }
    }
}