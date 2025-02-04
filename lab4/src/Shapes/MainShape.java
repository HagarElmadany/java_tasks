package Shapes;
import java.util.ArrayList;
import java.util.List;

abstract class Shape{
    public abstract void draw();
}
class Rectangle extends Shape{
    @Override
    public void draw(){
        System.out.println("Draw Rectangle");
    }
}

class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}

class Test{
    public static void drawShapes(List<Shape>shapes){
        for (int i=0;i<shapes.size();i++) {
        Shape shapeELE = shapes.get(i); 
        shapeELE.draw(); 
        }
    }
}

public class MainShape{
    public static void main(String args[]){
        List<Rectangle> Rects = new ArrayList<>();
        Rects.add(new Rectangle());
        Rects.add(new Rectangle());
        Rects.add(new Rectangle());
        
        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());
        
        Test obj = new Test();
        System.out.println("Drawing Rects:");
        obj.drawShapes(new ArrayList<Shape>(Rects));
        System.out.println("Drawing Circles:");
        obj.drawShapes(new ArrayList<Shape>(circles));
    }
}
