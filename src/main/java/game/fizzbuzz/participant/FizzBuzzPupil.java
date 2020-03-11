package game.fizzbuzz.participant;

import java.util.function.IntPredicate;

public class FizzBuzzPupil implements Pupil {
    private Pupil pupil;

    private IntPredicate divisibleByThreeAndFive = i -> i % 3 ==0  && i % 5 == 0;

    public FizzBuzzPupil(Pupil pupil) {
        this.pupil = pupil;
    }
    @Override
    public String sayTheNextNumber(int number) {
        return divisibleByThreeAndFive.test(number)
                ? "FizzBuzz"
                : pupil.sayTheNextNumber(number);
    }
}
