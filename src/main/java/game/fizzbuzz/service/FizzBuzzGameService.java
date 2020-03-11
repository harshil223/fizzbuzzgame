package game.fizzbuzz.service;

import game.fizzbuzz.component.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzGameService {

    @Autowired
    private ClassRoom classRoom;

    public String play(int number) {
        return classRoom.sayTheNextNumber(number);
    }
}
