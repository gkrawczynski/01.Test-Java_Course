package com.course.java.service;

import java.util.*;

public class FigureHelper {

    /* Find max Value in the Map */
    public static double getMaxValue(Map<String, Double> hashMap) {
        if (hashMap == null) {
            throw new NullPointerException();
        } else {
            Set set = hashMap.entrySet();
            Iterator iterator = set.iterator();
            double max = Double.MIN_VALUE;
            while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                double temp = (double) mapEntry.getValue();
                if (max < temp) {
                    max = temp;
                }
            }
            return max;
        }
    }

    /* Find Key for a given max Value in the Map */
    public static List<String> getKeysForMaxValue(Map<String, Double> hashMap, double maxValue) {
        if (hashMap == null || maxValue < 0) {
            throw new IllegalArgumentException();
        } else {
            List<String> keyList = new ArrayList<>();

            Set set = hashMap.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                double tempValue = (double) mapEntry.getValue();
                if (tempValue == maxValue) {
                    keyList.add((String) mapEntry.getKey());
                }
            }
            return keyList;
        }
    }

    /* d) napisz metode ktora napisze ktorego typu figur jest najwiecej w tablicy //(lub liscie figur) */
    public static List<String> getMostOccuringFigure(List<Figure> figures) {
        if (figures == null) {
            throw new NullPointerException();
        } else {
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
            Set set = figureOccurance.entrySet();
            Iterator iterator = set.iterator();
            int max = Integer.MIN_VALUE;

            while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                int temp = (int) mapEntry.getValue();
                if (max < temp) {
                    max = temp;
                }
            }

            /* Find most common Figure in the list of figures */
            Iterator i = set.iterator();
            while (i.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) i.next();
                int tmp = (int) mapEntry.getValue();
                if (tmp == max) {
                    mostCommonFigures.add((String) mapEntry.getKey());
                }
            }

            System.out.println("Most occuring figure: " + mostCommonFigures.toString());
            return mostCommonFigures;
        }
    }
}