package game.fizzbuzz.participant;

import java.util.function.IntPredicate;

public class BuzzPupil implements Pupil {
    private Pupil pupil;

    private IntPredicate divisibleByFive = i -> i % 5 == 0;

    public BuzzPupil(Pupil pupil) {
        this.pupil = pupil;
    }
    @Override
    public String sayTheNextNumber(int number) {
        return divisibleByFive.test(number)
                ? "Buzz"
                : pupil.sayTheNextNumber(number);
    }
}
