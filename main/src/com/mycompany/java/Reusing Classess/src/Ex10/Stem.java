package Ex10;

public class Stem extends Root{
    Component1 c1;
    Component2 c2;
    Component3 c3;

    public Stem(String message){
        super("Call from Stem"); // goi constructor cua Root
        c1 = new Component1("Hello from Stem");
        c2 = new Component2("Hi from Stem");
        c3 = new Component3("Huy");
        System.out.println("Stem: " + message);
    }
}
