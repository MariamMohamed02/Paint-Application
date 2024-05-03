/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Shapes;

import java.awt.Point;

/**
 *
 * @author ADMIN
 */
public interface Movable{
    public void setDraggingPoint(Point p);
    public Point getDraggingPoint();
    public void moveTo(Point p);
    public boolean contains(Point p);
    public void resize(Point p);
}
