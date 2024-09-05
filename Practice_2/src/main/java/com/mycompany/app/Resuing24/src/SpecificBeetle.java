class Beetle {
    static {
        System.out.println("Static block in Beetle");
    }

    public Beetle() {
        System.out.println("Constructor in Beetle");
    }

    public static void staticMethod() {
        System.out.println("Static method in Beetle");
    }
}

public class SpecificBeetle extends Beetle {
	static {
        System.out.println("Static block in SpecificBeetle");
    }

    public SpecificBeetle() {
        System.out.println("Constructor in SpecificBeetle");
    }
    public static void main(String[] args) {
    	SpecificBeetle.staticMethod();
    	
    	SpecificBeetle sb = new SpecificBeetle();
	}
}
