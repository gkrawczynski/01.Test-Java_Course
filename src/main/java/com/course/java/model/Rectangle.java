package com.course.java.model;

import com.course.java.service.Figure;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rectangle extends Figure {
    private int length;
    private int width;

    @Override
    public String getType(){
        return "Rectangle";
    }

    @Override
    public double calculatePerimeter(){
        if(length > 0 && width > 0){
            return  (length + width) * 2;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double calculateArea(){
        if(length > 0 && width > 0){
            return length * width;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Prostokąt o bokach " + length + "x" + width + ".";
    }
}
