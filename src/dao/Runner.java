package dao;

import common.Pupil;
import common.Pupils;
import dao.dao.DaoSpecificException;
import dao.dao.ObjectPupilsDao;
import dao.dao.TextPupilsDao;
import dao.sources.ObjectDataSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static final int PUPILS_COUNT = 6;

    public static void main(String[] args) throws IOException {
        //fillFilesInitially();

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
