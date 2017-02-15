package factory_method;

import common.Pupil;
import common.Pupils;

import java.util.Random;

public class Runner {

    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Default factory");
        createAndPrintPupil();

        System.out.println("StudentGirlFactory");
        Pupils.setPupilFactory(new StudentGirlFactory());
        createAndPrintPupil();

        System.out.println("StudentFactory");
        Pupils.setPupilFactory(new StudentFactory());
        createAndPrintPupil();
    }

    private static void createAndPrintPupil() {
        Pupil pupil = Pupils.createInstance(Pupils.randomStudentName(), 5);
        Pupils.fillPupilMarks(pupil);
        System.out.println("Pupil: " + pupil);
        Pupils.print(pupil);
        System.out.printf("Average mark = %.2f\n\n", Pupils.calculateAverageMark(pupil));
    }
}
