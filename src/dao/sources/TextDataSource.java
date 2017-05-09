package dao.sources;

import common.Pupil;
import common.Pupils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextDataSource {
    private static final String FILENAME = "text_data.txt";

    public List<Pupil> readPupilsAsText() throws IOException {
        List<Pupil> pupils = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(FILENAME));
        Pupil p;
        while ((p = readPupil(in)) != null) {
            pupils.add(p);
        }
        in.close();
        return pupils;
    }

    public void writePupilsAsText(List<Pupil> pupils) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(FILENAME);
        for (Pupil pupil : pupils) {
            out.print(Pupils.pupilToString(pupil));
        }
        out.close();
    }

    private Pupil readPupil(BufferedReader in) throws IOException {
        String secondName = in.readLine();
        if (secondName == null) {
            return null;
        }
        int subjectsCount = Integer.parseInt(in.readLine());
        Pupil pupil = Pupils.createInstance(secondName, subjectsCount);
        for (int i = 0; i < subjectsCount; i++) {
            String[] subjectData = in.readLine().split(" ");
            pupil.setSubjectAt(i, subjectData[0]);
            pupil.setMarkAt(i, Integer.parseInt(subjectData[1]));
        }
        return pupil;
    }


}
