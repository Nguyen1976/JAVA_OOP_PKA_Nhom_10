package Ex9_12;

public class Root {
    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();

    public Root(){
        System.out.println("Root");
    }

    // Phương thức dispose() của Root
    public void dispose() {
        System.out.println("Disposing Root");
        c3.dispose();
        c2.dispose();
        c1.dispose();
    }
}
