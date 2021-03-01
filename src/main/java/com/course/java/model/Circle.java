package com.course.java.model;

import com.course.java.service.Figure;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Circle extends Figure {
    private int radius;

    @Override
    public String getType(){
        return "Circle";
    }

    @Override
    public double calculatePerimeter(){
        if(radius > 0){
            return 2 * Math.PI * radius;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double calculateArea(){
        if(radius > 0){
            return Math.PI * Math.pow(radius, 2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Koło o promieniu " + radius + ".";
    }
}
