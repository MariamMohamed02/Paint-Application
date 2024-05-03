/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Map;

public class Circle extends ShapesAbstractClass{

   private int height;
    private int width;
   

    public int getHeightOval() {
        return height;
    }

    public void setHeightOval(int verticalRadius) {
        this.height = verticalRadius;
    }

    public int getWidthOval() {
        return width;
    }

    public void setWidthOval(int horizontalRadius) {
        this.width = horizontalRadius;
    }
    
  

    public Circle(Point position) {
        super(position);
    }
    


    @Override
    public void draw(Graphics canvas) {
       canvas.setColor(getFillColor());
       canvas.fillOval((int)getPosition().x, (int)getPosition().y, width, height);
       canvas.setColor(getColor());
       canvas.drawOval((int)getPosition().x, (int)getPosition().y,  width, height); 
       
       
        if(isSelected())
            {
                
                canvas.setColor(Color.BLACK);
                canvas.fillRect(getPosition().x - 5, getPosition().y - 5, 10, 10);
                canvas.fillRect(getPosition().x + (width) - 5,getPosition().y - 5, 10, 10);
                canvas.fillRect(getPosition().x - 5, getPosition().y+ (height )- 5, 10, 10);
                canvas.fillRect(getPosition().x + (width) - 5, getPosition().y + (height) - 5, 10, 10);
            }
        
    }
    
    
    
    public boolean TopLeft(Point p)
    {
        int x = getPosition().x;
        int y = getPosition().y;
        Rectangle r = new Rectangle(new Point(x  - 5, y - 5));
        r.setHeight(10); r.setWidth(10);
        
        if(r.contains(p)==true) 
        System.out.println("top left pressed");
        
        
        
        return r.contains(p);
    }
    
    public boolean TopRight(Point p)
    {
         int x = getPosition().x;
        int y = getPosition().y;
        Rectangle r = new Rectangle(new Point(x + (width) - 5, y - 5));
        
        r.setHeight(10); r.setWidth(10);
        
        
        
        return r.contains(p);
    }
    
    public boolean BottomLeft(Point p)
    {
         int x = getPosition().x;
        int y = getPosition().y;
        Rectangle r = new Rectangle(new Point(x  - 5, y + (height) - 5));
        r.setHeight(10); r.setWidth(10);
        
        
        
        return r.contains(p);
    }
    public boolean BottomRight(Point p)
    {
         int x = getPosition().x;
        int y = getPosition().y;
        Rectangle r = new Rectangle(new Point(x + (width) - 5, y +(height)  - 5));
        r.setHeight(10); r.setWidth(10);
        
        
        
        return r.contains(p); 
    }
    

    @Override
    public boolean contains(Point p) {

            
            double xdiff= pow((p.x  -   ((getPosition().x)+((width/2))) ) ,2);
            double ydiff= pow((p.y  -   ((getPosition().y)+((height/2))) )  ,2);
            double result= (   xdiff/(pow((width/2),2))      ) + (     ydiff/(pow((height/2),2))     );
         
            if (result<=1)
            {
                return true;
            }
            return false;
       
    } 
    @Override
    public void moveTo(Point p) {
        int xdiff = p.x - getDraggingPoint().x;
        int ydiff = p.y - getDraggingPoint().y;
        setPosition(new Point(getPosition().x + xdiff, getPosition().y + ydiff));
       
       
        
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
           
           
             //else if(getDraggingPoint().y>(getPosition().y +height -5 )&& getDraggingPoint().y<(getPosition().y +height+ 5)) //bottom left
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
       //else{
           // if( getDraggingPoint().y<(getPosition().y +5)&& getDraggingPoint().y>(getPosition().y - 5) )  //top right
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
