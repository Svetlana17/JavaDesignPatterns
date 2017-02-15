package factory_method;

import common.Pupil;

import java.util.Random;

public class Runner {

    private static Random random = new Random();
    private static String[] studentNames = {"Ivanov", "Petrov", "Sidorov", "Vasechkin", "Sokolova", "Savelyeva", "Kraynova", "Fedorova"};
    private static String[] subjectNames = {"Physics", "Algebra", "Geometry", "Philosophy", "Chemistry", "Biology", "Literature"};

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
        Pupil pupil = Pupils.createInstance(randomName(studentNames), 5);
        fillPupilMarks(pupil);
        System.out.println("Pupil: " + pupil);
        Pupils.print(pupil);
        System.out.printf("Average mark = %.2f\n\n", Pupils.calculateAverageMark(pupil));
    }

    private static void fillPupilMarks(Pupil pupil) {
        for (int i = 0; i < pupil.getSubjectsCount(); i++) {
            pupil.setSubjectAt(i, randomName(subjectNames));
            pupil.setMarkAt(i, randomMark());
        }
        pupil.addSubjectAndMark(randomName(subjectNames), randomMark());
    }

    private static String randomName(String[] names) {
        return names[random.nextInt(names.length)];
    }

    private static int randomMark() {
        return 2 + random.nextInt(4);
    }
}
