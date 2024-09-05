class Component1 {
    Component1(String message) {
        System.out.println("Component1 constructor with message: " + message);
    }

    void dispose() {
        System.out.println("Disposing Component1");
    }
}

class Component2 {
    Component2(int number) {
        System.out.println("Component2 constructor with number: " + number);
    }

    void dispose() {
        System.out.println("Disposing Component2");
    }
}

class Component3 {
    Component3(double value) {
        System.out.println("Component3 constructor with value: " + value);
    }

    void dispose() {
        System.out.println("Disposing Component3");
    }
}

class Root {
    Component1 c1;
    Component2 c2;
    Component3 c3;

    Root(String c1Message, int c2Number, double c3Value) {
        c1 = new Component1(c1Message);
        c2 = new Component2(c2Number);
        c3 = new Component3(c3Value);
        System.out.println("Root constructor");
    }

    void dispose() {
        System.out.println("Disposing Root");
        c1.dispose();
        c2.dispose();
        c3.dispose();
    }
}

public class Stem extends Root {
	Component1 c1;
    Component2 c2;
    Component3 c3;

    Stem(String c1Message, int c2Number, double c3Value) {
        super(c1Message, c2Number, c3Value);
        c1 = new Component1(c1Message);
        c2 = new Component2(c2Number);
        c3 = new Component3(c3Value);
        System.out.println("Stem constructor");
    }

    @Override
    void dispose() {
        System.out.println("Disposing Stem");
        // Dispose the components in Stem
        c1.dispose();
        c2.dispose();
        c3.dispose();
        // Dispose the components in Root
        super.dispose();//dispose của Root
    }
    
    public static void main(String[] args) {
    	Stem s = new Stem("Hello", 42, 3.14);
        // Gọi dispose để giải phóng tài nguyên
        s.dispose();
	}
}
