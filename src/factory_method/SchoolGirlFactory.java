package factory_method;

import common.Pupil;
import common.SchoolGirl;

public class SchoolGirlFactory implements PupilFactory {
    @Override
    public Pupil createInstance(String secondName, int subjectsCount) {
        return new SchoolGirl(secondName, subjectsCount);
    }
}
