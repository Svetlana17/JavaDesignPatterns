package factory_method;

import common.Pupil;

public class Pupils {

    private Pupils() {
    }

    private static PupilFactory pupilFactory = new StudentFactory();

    public static void print(Pupil pupil) {
        System.out.println("Student: " + pupil.getSecondName());
        for (int i = 0; i < pupil.getSubjectsCount(); i++) {
            System.out.printf("    %s : %s\n", pupil.getSubjectAt(i), pupil.getMarkAt(i));
        }
    }

    public static double calculateAverageMark(Pupil pupil) {
        int sum = 0;
        for (int i = 0; i < pupil.getSubjectsCount(); i++) {
            sum += pupil.getMarkAt(i);
        }
        return 1.0 * sum / pupil.getSubjectsCount();
    }

    public static void setPupilFactory(PupilFactory pupilFactory) {
        Pupils.pupilFactory = pupilFactory;
    }

    public static Pupil createInstance(String secondName, int subjectsCount) {
        return pupilFactory.createInstance(secondName, subjectsCount);
    }
}
