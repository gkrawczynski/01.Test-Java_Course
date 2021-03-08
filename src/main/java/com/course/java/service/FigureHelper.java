package com.course.java.service;

import java.util.*;

public class FigureHelper {

    /* b) Find max Value in the Map */
    public static double getMaxValue(Map<String, Double> hashMap) {
        if (hashMap == null) {
            throw new NullPointerException();
        }

        double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> stringDoubleEntry : hashMap.entrySet()) {
            double temp = stringDoubleEntry.getValue();
            if (max < temp) {
                max = temp;
            }
        }

        return max;
    }

    /* b) Find Key for a given max Value in the Map */
    public static List<String> getKeysForMaxValue(Map<String, Double> hashMap, double maxValue) {
        if (hashMap == null || maxValue < 0) {
            throw new IllegalArgumentException();
        }

        List<String> keyList = new ArrayList<>();

        for (Map.Entry<String, Double> stringDoubleEntry : hashMap.entrySet()) {
            double temp = stringDoubleEntry.getValue();
            if (temp == maxValue) {
                keyList.add(stringDoubleEntry.getKey());
            }
        }

        return keyList;
    }

    /* d) napisz metode ktora napisze ktorego typu figur jest najwiecej w tablicy //(lub liscie figur) */
    public static List<String> getMostOccuringFigure(List<Figure> figures) {
        if (figures == null) {
            throw new NullPointerException();
        }

        Map<String, Integer> figureOccurance = new HashMap<>();
        List<String> mostCommonFigures = new ArrayList<>();

        for (Figure f : figures) {
            String figureType = f.getType();

            if (!figureOccurance.containsKey(figureType)) {
                figureOccurance.put(figureType, 1);
            } else {
                figureOccurance.put(figureType, figureOccurance.get(figureType) + 1);
            }
        }

        /* Find max Value in the Map */
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> stringIntegerEntry1 : figureOccurance.entrySet()) {
            int temp = stringIntegerEntry1.getValue();
            if (max < temp) {
                max = temp;
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry2 : figureOccurance.entrySet()) {
            int tmp = stringIntegerEntry2.getValue();
            if (tmp == max) {
                mostCommonFigures.add(stringIntegerEntry2.getKey());
            }
        }

        System.out.println("Most occuring figures: " + mostCommonFigures.toString());
        return mostCommonFigures;
    }
}