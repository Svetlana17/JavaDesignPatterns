package factory_method;

import common.Pupil;
import common.StudentGirl;

public class StudentGirlFactory implements PupilFactory {
    @Override
    public Pupil createInstance(String secondName, int subjectsCount) {
        return new StudentGirl(secondName, subjectsCount);
    }
}
