public class Triangle extends Shape {
    @Override
    public void draw() { 
        System.out.println("Triangle.draw()");
    }
    
    public void erase() { 
    	System.out.println("Triangle.erase()");
    }
}