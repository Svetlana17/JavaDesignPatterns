package common;

import java.util.Arrays;

public class StudentGirl implements Pupil {

    private final String secondName;
    private Register[] registers;

    public StudentGirl(String secondName, int initialCountOfSubjects) {
        this.secondName = secondName;
        this.registers = new Register[initialCountOfSubjects];
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new Register();
        }
    }

    @Override
    public String getSecondName() {
        return secondName;
    }

    @Override
    public int getMarkAt(int index) {
        return registers[index].mark;
    }

    @Override
    public void setMarkAt(int index, int mark) {
        registers[index].mark = mark;
    }

    @Override
    public String getSubjectAt(int index) {
        return registers[index].subjectName;
    }

    @Override
    public void setSubjectAt(int index, String subject) {
        registers[index].subjectName = subject;
    }

    @Override
    public void addSubjectAndMark(String subjectName, int subjectMark) {
        registers = Arrays.copyOf(registers, registers.length + 1);
        registers[registers.length - 1] = new Register(subjectName, subjectMark);
    }

    @Override
    public int getSubjectsCount() {
        return registers.length;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        StudentGirl clone = (StudentGirl) super.clone();
        clone.registers = Arrays.copyOf(registers, registers.length);
        for (int i = 0; i < registers.length; i++) {
            clone.registers[i] = new Register(registers[i].subjectName, registers[i].mark);
        }
        return clone;
    }

    private static class Register {
        private String subjectName;
        private int mark;

        public Register() {
        }

        public Register(String subjectName, int mark) {
            this.subjectName = subjectName;
            this.mark = mark;
        }
    }
}
