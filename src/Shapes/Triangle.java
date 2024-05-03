/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author ADMIN
 */
public class Triangle extends ShapesAbstractClass{

    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(Point position, Point secondPoint, Point thirdPoint) {
        super(position);
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    @Override
    public void draw(Graphics canvas) {
        
        
       /* int xPoints[] = new int[]{getPosition().x, secondPoint.x,thirdPoint.x};
        int yPoints[] = new int[]{getPosition().x, secondPoint.y,thirdPoint.y};
        
        //canvas.setColor(getFillColor());
        //canvas.fillPolygon(xPoints, yPoints, 3);
        
        canvas.setColor(this.getColor());
        canvas.drawPolygon(xPoints, yPoints, 3);
        
        //canvas.setColor(getFillColor());
        //canvas.fillPolygon(xPoints, yPoints, 3);*/
        canvas.setColor(this.getColor());
        //g.setColor(getFillColor());
        
        
        int xPoints[] = new int[]{getPosition().x, secondPoint.x, thirdPoint.x};
        int yPoints[] = new int[]{getPosition().y, secondPoint.y, thirdPoint.y};
         canvas.setColor(getFillColor());
         canvas.fillPolygon(xPoints, yPoints, 3);
        
         canvas.setColor(this.getColor());
         canvas.drawPolygon(xPoints, yPoints, 3);
         
         if(isSelected())
            {
                canvas.setColor(Color.BLACK);
                canvas.fillRect(getPosition().x - 5, getPosition().y - 5, 10, 10);
                canvas.fillRect(secondPoint.x - 5,secondPoint.y - 5, 10, 10);
                canvas.fillRect(thirdPoint.x - 5, thirdPoint.y - 5, 10, 10);
                
            }

    }

    @Override
    public boolean contains(Point p) {
        /*int xPoints[] = new int[]{getPosition().x, secondPoint.x, thirdPoint.x};
        int yPoints[] = new int[]{getPosition().y, secondPoint.y, thirdPoint.y};

        Polygon po = new Polygon(xPoints, yPoints, 3);
System.out.println("contains result"+ po.contains(p));
      //  return po.contains(p);
      return po.contains(p);*/
        
        int xPoints[] = new int[]{getPosition().x, secondPoint.x, thirdPoint.x};
        int yPoints[] = new int[]{getPosition().y, secondPoint.y, thirdPoint.y};

        Polygon po = new Polygon(xPoints, yPoints, 3);

        return po.contains(p);
    }

    @Override
    public void moveTo(Point p) {
        /*int xdiff = p.x - getDraggingPoint().x;
        int ydiff = p.y - getDraggingPoint().y;
        setPosition(new Point(getPosition().x + xdiff, getPosition().y + ydiff));
        secondPoint = new Point(secondPoint.x+xdiff, secondPoint.y+ydiff);
        thirdPoint = new Point(thirdPoint.x+xdiff, thirdPoint.y+ydiff);
        //setPosition(new Point(getPosition().x + xdiff, getPosition().y + ydiff));*/
        
        int xdiff = p.x - getDraggingPoint().x;
        int ydiff = p.y - getDraggingPoint().y;
        secondPoint = new Point(secondPoint.x + xdiff, secondPoint.y + ydiff);
        thirdPoint = new Point(thirdPoint.x + xdiff, thirdPoint.y + ydiff);
        setPosition(new Point(getPosition().x + xdiff, getPosition().y + ydiff));
        

    }
    

    public boolean pointOne(Point p){
        
        int x1 = getPosition().x-5;
        int y1 = getPosition().y-5;
        Rectangle r1 = new Rectangle(new Point(x1 , y1 ));
        r1.setHeight(10); r1.setWidth(10);
        
        return (r1.contains(p)  );
        
    }
    
    public boolean pointTwo(Point p){
 
        int x2 = secondPoint.x-5;
        int y2 = secondPoint.y-5;
         Rectangle r2 = new Rectangle(new Point(x2 , y2 ));
        r2.setHeight(10); r2.setWidth(10);

        return ( r2.contains(p)  );
        
    }
    
    public boolean pointThree(Point p){
 
        int x3 = thirdPoint.x-5;
        int y3 = thirdPoint.y-5;
        Rectangle r3 = new Rectangle(new Point(x3 , y3 ));
        r3.setHeight(10); r3.setWidth(10);

        return ( r3.contains(p)  );
        
    }
    
    
    @Override
    public void resize(Point p) {
           
        int xdiff = p.x - getDraggingPoint().x;
        int ydiff = p.y - getDraggingPoint().y;
 
        if (pointOne(getDraggingPoint()) )
        {
 
        setPosition(new Point(getPosition().x + xdiff, getPosition().y + ydiff));
        }
        else if(pointTwo(getDraggingPoint()))
        {

        setSecondPoint(new Point(getSecondPoint().x + xdiff, getSecondPoint().y + ydiff));

        }
        else 
        {
       
        setThirdPoint(new Point(getThirdPoint().x + xdiff, getThirdPoint().y + ydiff));
        
        
        }
        
        
    }

}
