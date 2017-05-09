package dao.dao;

import common.Pupil;
import dao.sources.TextDataSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TextPupilsDao implements PupilsDao {

    private final TextDataSource dataSource;

    public TextPupilsDao() {
        dataSource = new TextDataSource();
    }

    @Override
    public void writePupils(List<Pupil> pupils) throws DaoSpecificException {
        try {
            dataSource.writePupilsAsText(pupils);
        } catch (FileNotFoundException e) {
            throw new DaoSpecificException(e);
        }
    }

    @Override
    public List<Pupil> readPupils() throws DaoSpecificException {
        try {
            return dataSource.readPupilsAsText();
        } catch (IOException e) {
            throw new DaoSpecificException(e);
        }
    }
}
