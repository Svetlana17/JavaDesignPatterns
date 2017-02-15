package factory_method;

import common.Pupil;

public interface PupilFactory {
    Pupil createInstance(String secondName, int subjectsCount);
}
