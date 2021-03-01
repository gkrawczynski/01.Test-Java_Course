package com.course.java.service;

import com.course.java.model.Circle;
import com.course.java.model.Rectangle;
import com.course.java.model.Square;
import lombok.Data;

import java.util.*;

@Data
public class Figure {
    private static List<Figure> figureList;

    public String getType() {
        return "Figure";
    }

    //1.
    public static String createSquare(int side) {
        return "Kwadrat o boku " + side + ".";
    }

    //2.
    public static String createCircle(int radius) {
        return "Koło o promieniu " + radius + ".";
    }

    //3.
    public static String createRectangle(int length, int width) {
        return "Prostokąt o bokach " + length + "x" + width + ".";
    }

    public double calculatePerimeter() {
        return 0;
    }

    public double calculateArea() {
        return 0;
    }


    public static void main(String[] args) {
        List<String> figures = List.of(Figure.createSquare(10), Figure.createCircle(20),
                Figure.createRectangle(10, 20), Figure.createSquare(15));

        //a)
        for (String f : figures) {
            System.out.print("Figura nr " + (figures.indexOf(f) + 1) + ": ");
            System.out.println(f);
        }


        //b)
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

        Map<String, Double> perimeterMap = new HashMap<>();
        Map<String, Double> areaMap = new HashMap<>();

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

        System.out.println("\nFigures with max perimeter: ");
        double max1 = FigureHelper.getMaxValue(perimeterMap);
        System.out.println(FigureHelper.getKeysForMaxValue(perimeterMap, max1));

        System.out.println("\nFigures with max area: ");
        double max2 = FigureHelper.getMaxValue(areaMap);
        System.out.println(FigureHelper.getKeysForMaxValue(areaMap, max2));

//        System.out.println("\nPerimeter map: ");
//        for (String s : perimeterMap.keySet()) {
//            System.out.println("K: " + s + ", V: " + perimeterMap.get(s));
//        }
//
//        System.out.println("\nArea map: ");
//        for (String s : areaMap.keySet()) {
//            System.out.println("K: " + s + ", V: " + areaMap.get(s));
//        }


        //c) ???


        //d)
        System.out.println();
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