
public class Hexagon extends Shape {
    @Override
    public void draw() { 
        System.out.println("Hexagon.draw()"); 
    }

    @Override
    public void erase() { 
        System.out.println("Hexagon.erase()"); 
    }
    
    @Override
    public void newMethod() {
    	System.out.println("Hexagon.newMethod()");
    }
}
