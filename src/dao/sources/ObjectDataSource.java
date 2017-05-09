package dao.sources;

import common.Pupil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectDataSource {
    private static final String FILENAME = "object_data.txt";

    public void writePupilsAsObjects(List<Pupil> pupils) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File(FILENAME)));
        for (Pupil pupil : pupils) {
            outputStream.writeObject(pupil);
        }
        outputStream.close();
    }

    public List<Pupil> readPupilsAsObjects() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File(FILENAME)));
        List<Pupil> pupils = new ArrayList<>();
        while (true) {
            try {
                pupils.add((Pupil) inputStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }
        inputStream.close();
        return pupils;
    }
}
