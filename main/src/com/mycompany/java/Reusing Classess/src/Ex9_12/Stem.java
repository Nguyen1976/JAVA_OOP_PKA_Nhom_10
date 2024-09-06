package Ex9_12;

public class Stem extends Root{
    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();

    public Stem(){
        System.out.println("Stem");
    }

    // Phương thức dispose() của Stem
    @Override
    public void dispose() {
        System.out.println("Disposing Stem");
        c3.dispose();
        c2.dispose();
        c1.dispose();
        // Gọi dispose() của lớp cơ sở Root
        super.dispose();
    }
}

