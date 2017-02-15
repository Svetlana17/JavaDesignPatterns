package common;

public interface Pupil {
    String getSecondName();

    String getSubjectAt(int index);

    void setSubjectAt(int index, String subject);

    int getMarkAt(int index);

    void setMarkAt(int index, int mark);

    void addSubjectAndMark(String subjectName, int subjectMark);

    int getSubjectsCount();
}
