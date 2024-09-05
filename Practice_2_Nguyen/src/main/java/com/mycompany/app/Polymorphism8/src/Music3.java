import java.util.Random;

class Instrument {
    void play(Note n) { 
    	System.out.println("Instrument.play() " + n); 
    }
    
    @Override
    public String toString() {
        return "Instrument";
    }
    
    void adjust() { 
    	System.out.println("Adjusting Instrument"); 
    }
}

class RandomInstrument {
	private Random rand = new Random(47);
	
	public Instrument next() {
		switch(rand.nextInt(4)) {
			default:
			case 0: return new Wind();
			case 1: return new Percussion();
			case 2: return new Stringed();
			case 3: return new Trumpet();
		}
	}
}

class Wind extends Instrument {
	@Override
    void play(Note n) { 
		System.out.println("Wind.play() " + n); 
    }
    
    @Override
    public String toString() {
        return "Wind";
    }
    
    @Override
    void adjust() { 
    	System.out.println("Adjusting Wind"); 
    }
}

class Percussion extends Instrument {
    @Override
    void play(Note n) { 
    	System.out.println("Percussion.play() " + n);
    }
    
    @Override
    public String toString() {
        return "Percussion";
    }
    
    @Override
    void adjust() { 
    	System.out.println("Adjusting Percussion"); 
    }
}

class Stringed extends Instrument {
    @Override
    void play(Note n) { 
    	System.out.println("Stringed.play() " + n);
    }
    
    @Override
    public String toString() {
        return "Stringed";
    }
    
    @Override
    void adjust() { 
    	System.out.println("Adjusting Stringed"); 
    }
}

class Brass extends Wind {
    @Override
    void play(Note n) { 
    	System.out.println("Brass.play() " + n); 
    }
    
    @Override
    public String toString() {
        return "Brass";
    }
    
    @Override
    void adjust() { 
    	System.out.println("Adjusting Brass"); 
    }
}

class Woodwind extends Wind {
    @Override
    void play(Note n) { 
    	System.out.println("Woodwind.play() " + n); 
    }
    
    @Override
    public String toString() {
        return "Woodwind";
    }
}

class Trumpet extends Instrument {
	@Override
    void play(Note n) { 
    	System.out.println("Trumpet.play() " + n); 
    }
    
    @Override
    public String toString() {
        return "Trumpet";
    }
}

public class Music3 {
	 public static void tune(Instrument i) {
	        i.play(Note.MIDDLE_C);
	    }
	    
	    public static void tuneAll(Instrument[] e) {
	        for (Instrument i : e) {
	            tune(i);
	            System.out.println(i); // In đối tượng Instrument sử dụng toString()
	        }
	    }
	    
	    public static void main(String[] args) {
	    	RandomInstrument gen = new RandomInstrument();
	        Instrument[] orchestra = new Instrument[4];
	        
	        for (int i = 0; i < orchestra.length; i++) {
	            orchestra[i] = gen.next(); // Tạo các đối tượng Instrument ngẫu nhiên
	        }
	        tuneAll(orchestra);
	    }
}
