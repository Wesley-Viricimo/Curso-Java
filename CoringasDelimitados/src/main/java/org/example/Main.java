package org.example;

import org.example.entities.Circle;
import org.example.entities.Rectangle;
import org.example.entities.Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> myShapes = new ArrayList<>();

        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        System.out.println("Total area: " + totalArea(myShapes));
    }

    public static double totalArea(List<? extends Shape> list) { //Informo que a minha lista pode ser de shape ou de qualquer tipo que seja um subtipo de shape
        double sum = 0.0;

        for (Shape s : list) {
            sum += s.area();
        }
        return sum;
    }
}