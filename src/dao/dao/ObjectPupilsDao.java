package dao.dao;

import common.Pupil;
import dao.sources.ObjectDataSource;

import java.io.IOException;
import java.util.List;

public class ObjectPupilsDao implements PupilsDao {

    private final ObjectDataSource dataSource;

    public ObjectPupilsDao() {
        dataSource = new ObjectDataSource();
    }

    @Override
    public void writePupils(List<Pupil> pupils) throws DaoSpecificException {
        try {
            dataSource.writePupilsAsObjects(pupils);
        } catch (IOException e) {
            throw new DaoSpecificException(e);
        }
    }

    @Override
    public List<Pupil> readPupils() throws DaoSpecificException {
        try {
            return dataSource.readPupilsAsObjects();
        } catch (ClassNotFoundException | IOException e) {
            throw new DaoSpecificException(e);
        }
    }
}
