package dao.dao;

import common.Pupil;

import java.util.List;

public interface PupilsDao {
    void writePupils(List<Pupil> pupils) throws DaoSpecificException;

    List<Pupil> readPupils() throws DaoSpecificException;
}
