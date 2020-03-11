package game.fizzbuzz.service;

import game.fizzbuzz.component.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzGameService {

    @Autowired
    private Class aClass;

    public String play(int number) {
        return aClass.sayTheNextNumber(number);
    }
}
