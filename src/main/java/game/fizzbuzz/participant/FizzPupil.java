package game.fizzbuzz.participant;

import java.util.function.IntPredicate;

public class FizzPupil implements Pupil {
    private Pupil pupil;

    private IntPredicate  divisibleByThree = i -> i % 3 == 0;

    public FizzPupil(Pupil pupil) {
        this.pupil = pupil;
    }
    @Override
    public String sayTheNextNumber(int number) {
        return divisibleByThree.test(number)
                ? "Fizz"
                : pupil.sayTheNextNumber(number);
    }
}
