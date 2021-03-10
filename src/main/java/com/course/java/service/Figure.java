package com.course.java.service;

import com.course.java.model.Circle;
import com.course.java.model.Rectangle;
import com.course.java.model.Square;
import lombok.Data;

import java.util.*;

@Data
public class Figure {
    private static List<Figure> figureList;
    int i;
    int length;
    int width;

    public String getType() {
        return "Figure";
    }

    public static Figure createSquare(int side) {
        return new Square(side);
    }


    public static Figure createCircle(int radius) {
        return new Circle(radius);
    }


    public static Figure createRectangle(int length, int width) {
        return new Rectangle(length, width);
    }

    public double calculatePerimeter() {
        return 0;
    }

    public double calculateArea() {
        return 0;
    }


    public static void main(String[] args) {
        List<Figure> figures = List.of(Figure.createSquare(10), Figure.createCircle(20),
                Figure.createRectangle(10, 20), Figure.createSquare(15));

        // 1.a)
        System.out.println("a)");
        int number = 1;
        for (Figure f : figures) {
            System.out.println("Figura nr " + number + ": " + f);
            number++;
        }

        System.out.println();
        for (Figure f : figures) {
            System.out.println("Figura nr " + (figures.indexOf(f) + 1) + ": " + f);
        }


        // 1.b)
        figureList = List.of(
                new Square(5),
                new Square(8),
                new Circle(7),
                new Circle(9),
                new Circle(11),
                new Circle(13),
                new Rectangle(3, 6),
                new Rectangle(3, 6),
                new Rectangle(3, 6),
                new Rectangle(2, 4)
        );

        /*
          Solution I: map
           znajdź figurę z największym obwodem
           znajdź figurę z największym polem
        */
        Map<String, Double> perimeterMap = new HashMap<>();
        Map<String, Double> areaMap = new HashMap<>();

        System.out.println("\nb)");
        for (Figure f : figureList) {
            String figureType = f.getType();

            if (!perimeterMap.containsKey(figureType)) {
                perimeterMap.put(figureType, f.calculatePerimeter());
            } else {
                double max = perimeterMap.get(figureType);
                double temp = f.calculatePerimeter();
                if (max < temp) {
                    max = temp;
                    perimeterMap.put(figureType, max);
                }
            }

            if (!areaMap.containsKey(figureType)) {
                areaMap.put(figureType, f.calculateArea());
            } else {
                double max = areaMap.get(figureType);
                double temp = f.calculateArea();
                if (max < temp) {
                    max = temp;
                    areaMap.put(figureType, max);
                }
            }
        }

        System.out.print("Figures with max perimeter: ");
        double max1 = FigureHelper.getMaxValue(perimeterMap);
        System.out.print(FigureHelper.getKeysForMaxValue(perimeterMap, max1));

        System.out.print("\nFigures with max area: ");
        double max2 = FigureHelper.getMaxValue(areaMap);
        System.out.println(FigureHelper.getKeysForMaxValue(areaMap, max2));


        /*
           Solution II: for each
            znajdź figurę z największym obwodem
        */
        double tempMaxPerimeter = Integer.MIN_VALUE;
        for (Figure figure : figureList) {
            double v = figure.calculatePerimeter();
            if (v > tempMaxPerimeter) {
                tempMaxPerimeter = v;
            }
        }
        for (Figure figure : figureList) {
            if (figure.calculatePerimeter() == tempMaxPerimeter) {
                System.out.println("\nMax perimiter figures: " + figure);
            }
        }

        /* znajdź figurę z największym polem */
        double tempMaxArea = Integer.MIN_VALUE;
        for (Figure figure : figureList) {
            double v = figure.calculateArea();
            if (v > tempMaxArea) {
                tempMaxArea = v;
            }
        }
        for (Figure figure : figureList) {
            if (figure.calculateArea() == tempMaxArea) {
                System.out.println("Max area figures: " + figure);
            }
        }


        /*
           Solution III: stream
            znajdź figurę z największym obwodem
        */
        System.out.print("\nMax perimiter figures: ");
        System.out.println(figureList.stream()
                .max(Comparator.comparingDouble(Figure::calculatePerimeter)).orElse(null));

        /* znajdź figurę z największym polem */
        System.out.print("Max area figures: ");
        System.out.println(figureList.stream()
                .max(Comparator.comparingDouble(Figure::calculateArea)).orElse(null));


        //c)
        for (Figure f : figures) {
            if (f.equals(Figure.createRectangle(10, 20))) {
                System.out.println("\nc)\ntu powinno wejsc: index=" + figures.indexOf(f));
            }
        }


        //d) napisz metode ktora napisze ktorego typu figur jest najwiecej w tablicy lub liscie figur
        System.out.println("\nd)");
        FigureHelper.getMostOccuringFigure(figureList);
    }
}
/*
Zadanie 01:
a) Napisz kod w taki sposób aby poniższy fragment zadziałał i dał dokładnie taki wynik jak oczekuje:
Figura[] figury = {Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10,20),
        Figura.stworzKwadrat(15)};

        for(Figura f : figury { System.out.println(f); }

System.out powinien wypisac:
 Figura nr 1: Kwadrat o boku 10.
 Figura nr 2: Koło o promienu 10.
 Figura nr 3: Prostokat o bokach 10x20.
 Figura nr 4: Kwadrat o boku 15.

b)Następnie: (na tej liście na które Ty stworzłeś, nie z punktu a) )
 - znajdź figurę z największym obwodem
 - znajdź figurę z największym polem

c) for(Figura f : figury) { if(f.equals(Figura.stworzProstokat(10,20)){ System.out.println("tu powinno wejsc"); } }

d) napisz metode ktora napisze ktorego typu figur jest najwiecej w tablicy // (lub liscie figur)

ps: mozesz sobie zmienic tablice figur na liste figur:)
 */