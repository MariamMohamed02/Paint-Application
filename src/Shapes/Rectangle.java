/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Rectangle extends ShapesAbstractClass{ 
    private int width; 
    private int height; 
    

    public Rectangle(Point position) {
        super(position);
        this.width=width;
        this.height=height;
        
    }
 

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
  

    @Override
    public void draw(Graphics canvas) {
        
        canvas.setColor(getColor());
        int x = getPosition().x;
        int y = getPosition().y;
        canvas.setColor(getFillColor());
        canvas.fillRect(x, y, width, height);
        canvas.setColor(getColor());
        canvas.drawRect(x, y, width, height);
        
         if(isSelected())
            {
                canvas.setColor(Color.BLACK);
                canvas.fillRect(getPosition().x - 5, getPosition().y - 5, 10, 10);
                canvas.fillRect(getPosition().x + width - 5,getPosition().y - 5, 10, 10);
                canvas.fillRect(getPosition().x - 5, getPosition().y+ height - 5, 10, 10);
                canvas.fillRect(getPosition().x + width - 5, getPosition().y + height - 5, 10, 10);
            }
           
        
    }

    @Override
    public void moveTo(Point p) {
       int xdiff = p.x - getDraggingPoint().x;
       int ydiff = p.y - getDraggingPoint().y;
       setPosition(new Point(getPosition().x + xdiff, getPosition().y + ydiff));
        //setPosition(new Point( (xdiff +(int)getPosition().getX()), (ydiff+(int)getPosition().getY())  ));
        
        
        
        
    }

    @Override
    public boolean contains(Point p) {
        
        int xPoints[] = new int[]{(int)getPosition().getX()  , ((int)getPosition().getX()+width) , ((int)getPosition().getX()+width) , (int)getPosition().getX() };
        int yPoints[] = new int[]{(int)getPosition().getY(),  (int)getPosition().getY()  ,  ((int)getPosition().getY()+height) ,  ((int)getPosition().getY()+height)};
        
        Polygon po = new Polygon(xPoints, yPoints, 4);
        
       
        
        return po.contains(p);

//         Point position = getPosition();
//        java.awt.Rectangle r = new java.awt.Rectangle();
//        r.setLocation(position);
//        r.setSize(width, height);
//        return r.contains(p);
     
        
       
    }

    public boolean TopLeft(Point p)
    {
        int x = getPosition().x;
        int y = getPosition().y;
        Rectangle r = new Rectangle(new Point(x  - 5, y - 5));
        r.setHeight(10); r.setWidth(10);
        
       
       
        
        
        
        return r.contains(p);
    }
    
    public boolean TopRight(Point p)
    {
         int x = getPosition().x;
        int y = getPosition().y;
        Rectangle r = new Rectangle(new Point(x + width - 5, y - 5));
        r.setHeight(10); r.setWidth(10);
        
        
        
        return r.contains(p);
    }
    
    public boolean BottomLeft(Point p)
    {
        int x = getPosition().x;
        int y = getPosition().y;
        Rectangle r = new Rectangle(new Point(x  - 5, y + height - 5));
        r.setHeight(10); r.setWidth(10);
        
       
        
        return r.contains(p);
    }
    public boolean BottomRight(Point p)
    {
        int x = getPosition().x;
        int y = getPosition().y;
        Rectangle r = new Rectangle(new Point(x + width - 5, y + height - 5));
        r.setHeight(10); r.setWidth(10);
        
       
        
        return r.contains(p); 
    }
    
    
    @Override
    public void resize(Point p) {
         if(TopLeft(getDraggingPoint())) 
            {
                int xdiff = p.x- getDraggingPoint().x;
                int ydiff = p.y - getDraggingPoint().y;
             
             
             setPosition(new Point(p.x, p.y));
              
             width=width-xdiff;
             height=height-ydiff;
            
            }
           
           
            else if(BottomLeft(getDraggingPoint()))
           {
           
               int xdiff = p.x- getDraggingPoint().x;
               int ydiff = p.y - getDraggingPoint().y;

             setPosition(new Point(getPosition().x+xdiff, getPosition().y));
             
              width=width-xdiff;
             height=height+ydiff;

           }    
    
      // }
             else if(TopRight(getDraggingPoint())) 
            {
            
                 int xdiff = p.x- getDraggingPoint().x;
               int ydiff = p.y - getDraggingPoint().y;
               
               setPosition(new Point(getPosition().x, getPosition().y+ydiff));
               width=width+xdiff;
             height=height-ydiff;

            }
             
             //else if(getDraggingPoint().y>(getPosition().y +height -5 )&& getDraggingPoint().y<(getPosition().y +height+ 5)) //bottom right
             else 
             {
           
               int xdiff = p.x- getDraggingPoint().x;
               int ydiff = p.y - getDraggingPoint().y;

             setPosition(new Point(getPosition().x, getPosition().y));
             
              width=width+xdiff;
             height=height+ydiff;

           } 
    //}
    
 
       if (width < 0) {
            width = -1 * width;
            getPosition().x -= width;
        }
        if (height < 0) {
            height = -1 * height;
            getPosition().y -= height;
        }
    }

        
    
}
