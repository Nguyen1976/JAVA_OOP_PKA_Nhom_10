class Base {
	Base(String message) {
		System.out.println("Base constructor with message" + message);
	}
}
	
class Derived extends Base {
	// Constructor không mặc định của lớp Derived, gọi constructor của lớp Base
    Derived(String message) {
        super(message);  // Gọi constructor của lớp Base với đối số
        System.out.println("Derived constructor with message: " + message);
    }
    
    // Constructor mặc định của lớp Derived, gọi constructor của lớp Base với đối số mặc định
    Derived() {
        this("Default message");  // Gọi constructor không mặc định của lớp Derived
        System.out.println("Derived default constructor");
    }
}

public class Main {
	public static void main(String[] args) {
		// Tạo đối tượng của lớp Derived bằng constructor không mặc định
        System.out.println("Creating Derived with custom message:");
        Derived d1 = new Derived("Custom message");

        // Tạo đối tượng của lớp Derived bằng constructor mặc định
        System.out.println("\nCreating Derived with default constructor:");
        Derived d2 = new Derived();
	}
}