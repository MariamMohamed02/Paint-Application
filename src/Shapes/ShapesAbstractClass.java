/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author ADMIN
 */
public abstract class ShapesAbstractClass implements Shape, Movable{
    
    private Point position; 
    private Color color=Color.BLACK; 
    private Color fillColor = new Color(0,0,0,0);
    private Point DraggingPoint;
    private boolean selected; 

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
    
    
    public ShapesAbstractClass(Point position) {
        this.position = position;
    }
    
@Override
    public void setPosition(Point position) {
        this.position=position; 
    }

    @Override
    public Point getPosition() {
       return position; 
    }


    @Override
    public void setColor(Color color) {
      this.color=color; 
    }

    @Override
    public Color getColor() {
      return color; 
    }

    @Override
    public void setFillColor(Color fillColor) {
       this.fillColor=fillColor;
    }

    @Override
    public Color getFillColor() {
       return fillColor;
    }
    
     @Override
    public Point getDraggingPoint() {
        return DraggingPoint;
    }

    @Override
    public void setDraggingPoint(Point DraggingPoint) {
        this.DraggingPoint = DraggingPoint;
    }
  
   
    
}
