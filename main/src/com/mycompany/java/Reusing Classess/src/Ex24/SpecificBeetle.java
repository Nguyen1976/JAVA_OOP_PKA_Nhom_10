package Ex24;

public class SpecificBeetle extends Beetle{
    static {
        System.out.println("Static block in SpecificBeetle");
    }

    public SpecificBeetle(){
        System.out.println("Constructor in SpecificBeetle");
    }

    public static void main(String[] args) {
        SpecificBeetle.staticMethod();

        SpecificBeetle sp = new SpecificBeetle();
    }
}
