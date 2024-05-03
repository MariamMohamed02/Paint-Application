/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ShapeEngine implements DrawingEngine {

   private ArrayList<Shape> x = new ArrayList<>();

    @Override
    public void addShape(Shape shape) {
        x.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {

        x.remove(shape);

    }

    @Override
    public Shape[] getShapes() {
        Shape[] xArray = new Shape[x.size()];
        xArray = x.toArray(xArray);

        return xArray;

    }

    @Override
    public void refresh(Graphics canvas) {
        for (int i = 0; i < x.size(); i++) {
            x.get(i).draw(canvas);
        }
    }

}
