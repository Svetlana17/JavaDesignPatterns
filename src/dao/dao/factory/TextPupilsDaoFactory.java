package dao.dao.factory;

import dao.dao.PupilsDao;
import dao.dao.TextPupilsDao;

public class TextPupilsDaoFactory implements PupilsDaoFactory {
    @Override
    public PupilsDao createPupilsDao() {
        return new TextPupilsDao();
    }
}
