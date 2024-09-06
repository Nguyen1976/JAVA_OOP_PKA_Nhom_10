package Ex10;

public class Root {
    Component1 c1;
    Component2 c2;
    Component3 c3;

    public Root(String c){
        c1 = new Component1("Hello");
        c2 = new Component2("Hello");
        c3 = new Component3("Hi");
        System.out.println("Root: " + c);
    }
}
