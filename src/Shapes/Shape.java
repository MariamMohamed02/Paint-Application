/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Shapes;


public interface Shape {
    
    public void setPosition(java.awt.Point position);
    public java.awt.Point getPosition();
    public void setColor(java.awt.Color color);
    public java.awt.Color getColor();
    public void setFillColor(java.awt.Color fcolor);
    public java.awt.Color getFillColor();
    public void draw(java.awt.Graphics canvas);
    
}
