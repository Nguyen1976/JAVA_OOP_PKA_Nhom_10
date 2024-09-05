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
	        Instrument[] orchestra = {
	            new Wind(),
	            new Percussion(),
	            new Stringed(),
	            new Brass(),
	            new Woodwind(),
	            new Trumpet()
	        };
	        tuneAll(orchestra);
	    }
}
