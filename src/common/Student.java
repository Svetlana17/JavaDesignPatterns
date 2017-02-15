package common;

import java.util.Arrays;

public class Student implements Pupil {

    private final String secondName;
    private int[] marks;
    private String[] subjects;

    public Student(String secondName, int initialCountOfSubjects) {
        this.secondName = secondName;
        this.marks = new int[initialCountOfSubjects];
        this.subjects = new String[initialCountOfSubjects];
    }

    @Override
    public String getSecondName() {
        return secondName;
    }

    @Override
    public int getMarkAt(int index) {
        return marks[index];
    }

    @Override
    public void setMarkAt(int index, int mark) {
        marks[index] = mark;
    }

    @Override
    public String getSubjectAt(int index) {
        return subjects[index];
    }

    @Override
    public void setSubjectAt(int index, String subject) {
        subjects[index] = subject;
    }

    @Override
    public void addSubjectAndMark(String subjectName, int subjectMark) {
        subjects = Arrays.copyOf(subjects, subjects.length + 1);
        subjects[subjects.length - 1] = subjectName;
        marks = Arrays.copyOf(marks, marks.length + 1);
        marks[marks.length - 1] = subjectMark;
    }

    @Override
    public int getSubjectsCount() {
        return subjects.length;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student clone = (Student) super.clone();
        clone.subjects = Arrays.copyOf(subjects, subjects.length);
        clone.marks = Arrays.copyOf(marks, marks.length);
        return clone;
    }
}
