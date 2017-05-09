package dao;

import common.Pupil;
import common.Pupils;
import dao.dao.DaoSpecificException;
import dao.dao.ObjectPupilsDao;
import dao.dao.PupilsDao;
import dao.dao.TextPupilsDao;
import dao.dao.factory.ObjectPupilsDaoFactory;
import dao.dao.factory.PupilsDaoFactory;
import dao.dao.factory.TextPupilsDaoFactory;
import dao.sources.ObjectDataSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static final int PUPILS_COUNT = 6;

    private static final PupilsDaoFactory FACTORY = new ObjectPupilsDaoFactory();

    public static void main(String[] args) throws IOException {
        //fillFilesInitially();
        PupilsDao dao = FACTORY.createPupilsDao();
        try {
            List<Pupil> pupils = dao.readPupils();
            System.out.println("Data read");
            for (Pupil pupil : pupils) {
                System.out.println(Pupils.pupilToString(pupil));
            }
        } catch (DaoSpecificException e) {
            e.printStackTrace();
        }
    }

    private static void fillFilesInitially() {
        List<Pupil> pupils = makePupils();
        try {
            new TextPupilsDao().writePupils(pupils);
            new ObjectPupilsDao().writePupils(pupils);
        } catch (DaoSpecificException e) {
            System.err.println("Something went terrible while filling");
        }
    }

    private static List<Pupil> makePupils() {
        List<Pupil> pupils = new ArrayList<>();
        for (int i = 0; i < PUPILS_COUNT; i++) {
            Pupil pupil = Pupils.createInstance(Pupils.randomStudentName(), 10);
            Pupils.fillPupilMarks(pupil);
            pupils.add(pupil);
        }
        return pupils;
    }
}
