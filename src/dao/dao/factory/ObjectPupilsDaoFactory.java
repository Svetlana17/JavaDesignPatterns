package dao.dao.factory;

import dao.dao.ObjectPupilsDao;
import dao.dao.PupilsDao;

public class ObjectPupilsDaoFactory implements PupilsDaoFactory {
    @Override
    public PupilsDao createPupilsDao() {
        return new ObjectPupilsDao();
    }
}
