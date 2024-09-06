package Ex24;

public class Beetle {
    static {
        System.out.println("Static block in Beetle");
    }

    public Beetle(){
        System.out.println("Constructor in Beetle");
    }

    public static void staticMethod(){
        System.out.println("Static method in Beetle");
    }
}
