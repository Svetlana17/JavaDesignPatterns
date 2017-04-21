package strategy;

import common.Pupil;
import common.Pupils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    private static final int PUPILS_COUNT = 10;

    public static void main(String[] args) {
        List<Pupil> pupils = makePupils();
        System.out.println("Initial array:");
        printPupilsAvgMarks(pupils);

        SortUtils.sort(pupils, list -> {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size() - 1; j++) {
                    Pupil pupil1 = pupils.get(j);
                    Pupil pupil2 = pupils.get(j + 1);
                    if (Pupils.calculateAverageMark(pupil1) > Pupils.calculateAverageMark(pupil2)) {
                        swap(pupils, j, j + 1);
                    }
                }
            }
        });
        System.out.println("Sorted asc:");
        printPupilsAvgMarks(pupils);

        SortUtils.sort(pupils, list -> {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size() - 1; j++) {
                    Pupil pupil1 = pupils.get(j);
                    Pupil pupil2 = pupils.get(j + 1);
                    if (Pupils.calculateAverageMark(pupil1) < Pupils.calculateAverageMark(pupil2)) {
                        swap(pupils, j, j + 1);
                    }
                }
            }
        });
        System.out.println("Sorted desc:");
        printPupilsAvgMarks(pupils);
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

    private static void printPupilsAvgMarks(List<Pupil> pupils) {
        double[] avg = new double[pupils.size()];
        for (int i = 0; i < pupils.size(); i++) {
            avg[i] = Pupils.calculateAverageMark(pupils.get(i));
        }
        System.out.println(Arrays.toString(avg));
    }

    private static <T> void swap(List<T> list, int i, int j) {
        T swap = list.get(i);
        list.set(i, list.get(j));
        list.set(j, swap);
    }
}
