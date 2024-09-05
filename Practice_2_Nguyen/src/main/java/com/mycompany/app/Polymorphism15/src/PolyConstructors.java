class Glyph {
    void draw() { 
        System.out.println("Glyph.draw()"); 
    }
    
    Glyph() {
    	System.out.println("Glyph() before draw()");
        draw(); // Đây là lệnh gọi đa hình.
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    
    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    
    void draw() { 
    	System.out.println("RoundGlyph.draw(), radius = " + radius); 
    }
}

class RectangularGlyph extends Glyph {
    private int width = 0;
    private int height = 0;
    
    RectangularGlyph(int w, int h) {
        width = w;
        height = h;
        System.out.println("RectangularGlyph.RectangularGlyph(), width = " + width + ", height = " + height);
    }
    
    void draw() { 
        System.out.println("RectangularGlyph.draw(), width = " + width + ", height = " + height); 
    }
}

public class PolyConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
        new RectangularGlyph(10, 20);
	}
}
