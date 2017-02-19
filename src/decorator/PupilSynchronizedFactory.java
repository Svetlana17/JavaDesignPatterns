package decorator;

import common.Pupil;
import factory_method.PupilFactory;

public class PupilSynchronizedFactory implements PupilFactory {
    @Override
    public Pupil createInstance(String secondName, int subjectsCount) {
        return new PupilSynchronized(secondName, subjectsCount);
    }
}
