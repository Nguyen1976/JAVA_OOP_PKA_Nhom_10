package Ex23;

public class ExampleClass {
    static {
        System.out.println("Static block executed");
    }

    static int stacticField = 42;

    //Constructor
    public ExampleClass(){
        System.out.println("Constructor executed");
    }

    //Static method
    public static void staticMethod(){
        System.out.println("Static method executed");
    }

    public static void main(String[] args) {
        System.out.println("Accessing static field: " + ExampleClass.stacticField);

        ExampleClass instance = new ExampleClass();
        ExampleClass.staticMethod();
    }
}
