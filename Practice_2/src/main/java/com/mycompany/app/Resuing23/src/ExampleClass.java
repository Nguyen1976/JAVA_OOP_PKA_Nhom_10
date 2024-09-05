
public class ExampleClass {
	static {
        System.out.println("Static block executed");
    }

    static int staticField = 42;

    // Constructor
    public ExampleClass() {
        System.out.println("Constructor executed");
    }

    // Static method
    public static void staticMethod() {
        System.out.println("Static method executed");
    }
    
    public static void main(String[] args) {
        System.out.println("Accessing static field: " + ExampleClass.staticField);

        ExampleClass instance = new ExampleClass();

        ExampleClass.staticMethod();
	}
}
