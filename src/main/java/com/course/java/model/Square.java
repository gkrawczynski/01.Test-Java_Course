package com.course.java.model;

import com.course.java.service.Figure;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Square extends Figure {
    private int side;

    @Override
    public String getType(){
        return "Square";
    }

    @Override
    public double calculatePerimeter(){
        if(side > 0){
            return 4 * side;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double calculateArea(){
        if(side > 0){
            return Math.pow(side, 2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Kwadrat o boku " + side + ".";
    }
}
