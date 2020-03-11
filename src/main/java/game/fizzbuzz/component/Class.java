package game.fizzbuzz.component;

import game.fizzbuzz.participant.*;
import org.springframework.stereotype.Component;

/**
 * uses chain of responsibility design pattern
 * responsibilities of printing Fizz or Buzz or FizzBuzz are divided by individual class
 * this design provides flexibility to print other word based on different condition
 */
@Component
public class Class implements Pupil {

    private NumberPupil numberPupil;
    private FizzPupil fizzPupil;
    private BuzzPupil buzzPupil;
    private FizzBuzzPupil fizzBuzzPupil;

    /**
     * Order of the participants is important.
     * The game cannot be started with FizzBuzzPupil whose next participant is NumberPupil
     */
    public Class() {
        numberPupil = new NumberPupil();
        fizzPupil = new FizzPupil(numberPupil);
        buzzPupil = new BuzzPupil(fizzPupil);
        fizzBuzzPupil = new FizzBuzzPupil(buzzPupil);
    }
    @Override
    public String sayTheNextNumber(int number) {
        return fizzBuzzPupil.sayTheNextNumber(number);
    }
}