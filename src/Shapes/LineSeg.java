/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.Map;

public class LineSeg extends ShapesAbstractClass{
    
    private Point end;

    public LineSeg(Point position) {
        super(position);
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }



    @Override
    public void draw(Graphics canvas) {
        //changed getPosition to getX and casted to int
        
            canvas.setColor(getColor());
            canvas.drawLine((int)getPosition().getX() ,(int) getPosition().getY(),end.x,end.y);
            if(isSelected())
            {
                canvas.setColor(Color.BLACK);
                canvas.fillRect(getPosition().x - 5, getPosition().y - 5, 10, 10);
                canvas.fillRect(end.x - 5,end.y - 5, 10, 10);
            }
           
    }

    @Override
    public void moveTo(Point p) {
        //changed getPosition to getX and casted to int
         int xdiff = p.x - getDraggingPoint().x;
         int ydiff = p.y - getDraggingPoint().y;
         end = new Point(end.x + xdiff, end.y + ydiff);
         //used to be setPosition(p);
         setPosition(new Point(getPosition().x+xdiff,getPosition().y+ydiff));    
    }

    @Override
    public boolean contains(Point p) {
        //changed getPosition to getX and casted to int
        int x1, y1, x2, y2;
        x1 = getPosition().x;
        y1 = getPosition().y;
        x2 = end.x;
        y2 = end.y;
        Line2D.Float x = new Line2D.Float(x1, y1, x2, y2);
//        Line2D.Float y = new Line2D.Float(p.x,p.y,p.x,p.y);
//        System.out.println("contains result"+ x.intersectsLine(y));
//         return x.intersectsLine(y);
        double space; 
        space=x.ptSegDist(p);
        if (space<3)
        return true; 
        else return false; 
    }

    public boolean UpperPoint(Point p)
    {
        int x=getPosition().x;
        int y=getPosition().y;
        Rectangle r = new Rectangle(new Point(x-5,y-5));
        r.setHeight(10);
        r.setWidth(10);
        System.out.println("upper point contains: " +r.contains(p));
        return r.contains(p);
    }
    
    public boolean LowerPoint(Point p)
    {
        int x=end.x;
        int y=end.y;
        Rectangle r = new Rectangle(new Point(x-5,y-5));
        r.setHeight(10);
        r.setWidth(10);
        System.out.println("Lower point contains: " +r.contains(p));
        return r.contains(p);
    }
    
    
    
    @Override
    public void resize(Point p) {
         if (UpperPoint(getDraggingPoint())) {
            setPosition(new Point(p.x,p.y));
        } else if (LowerPoint(getDraggingPoint())) {
            setEnd(new Point(p.x,p.y));
        }
    }

    
    
}
