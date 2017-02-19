package decorator;

import common.Student;

public class PupilSynchronized extends Student {
    public PupilSynchronized(String secondName, int initialCountOfSubjects) {
        super(secondName, initialCountOfSubjects);
    }

    @Override
    public synchronized String getSecondName() {
        return "Synchronized " + super.getSecondName();
    }

    @Override
    public synchronized int getMarkAt(int index) {
        return super.getMarkAt(index);
    }

    @Override
    public synchronized void setMarkAt(int index, int mark) {
        super.setMarkAt(index, mark);
    }

    @Override
    public synchronized String getSubjectAt(int index) {
        return super.getSubjectAt(index);
    }

    @Override
    public synchronized void setSubjectAt(int index, String subject) {
        super.setSubjectAt(index, subject);
    }

    @Override
    public synchronized void addSubjectAndMark(String subjectName, int subjectMark) {
        super.addSubjectAndMark(subjectName, subjectMark);
    }

    @Override
    public synchronized int getSubjectsCount() {
        return super.getSubjectsCount();
    }

    @Override
    public synchronized Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
