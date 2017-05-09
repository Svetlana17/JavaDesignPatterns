package prototype;

import common.Pupil;
import common.Pupils;
import factory_method.SchoolGirlFactory;

public class Runner {

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();

        Pupil student = Pupils.createInstance(Pupils.randomStudentName(), 5);
        Pupils.fillPupilMarks(student);
        test(student, prototype);

        Pupils.setPupilFactory(new SchoolGirlFactory());
        Pupil studentGirl = Pupils.createInstance(Pupils.randomStudentName(), 5);
        Pupils.fillPupilMarks(studentGirl);
        test(studentGirl, prototype);
    }

    private static void test(Pupil instance, Prototype prototype) throws CloneNotSupportedException {
        System.out.println("Initial instance:");
        System.out.println(instance);
        Pupils.log(instance);

        prototype.setPrototype(instance);
        Pupil clonedInstance = prototype.createInstance();
        System.out.println("Cloned instance:");
        System.out.println(instance);
        Pupils.log(clonedInstance);

        instance.setSubjectAt(0, "Removed Subject");
        instance.setMarkAt(0, -1);
        System.out.println("Initial instance after change:");
        Pupils.log(instance);

        System.out.println("Cloned instance after change:");
        Pupils.log(clonedInstance);
    }
}
