class Component1 {
    Component1() {
        System.out.println("Component1 constructor");
    }
}

class Component2 {
    Component2() {
        System.out.println("Component2 constructor");
    }
}

class Component3 {
    Component3() {
        System.out.println("Component3 constructor");
    }
}

class Root {
    Component1 c1;
    Component2 c2;
    Component3 c3;

    Root() {
        // Khởi tạo các đối tượng của các component
        c1 = new Component1();
        c2 = new Component2();
        c3 = new Component3();
        System.out.println("Root constructor");
    }
}

public class Stem extends Root {
	 Component1 c1;
	 Component2 c2;
	 Component3 c3;

	 Stem() {
	     // Khởi tạo các đối tượng của các component trong lớp Stem
	     c1 = new Component1();
	     c2 = new Component2();
	     c3 = new Component3();
	     System.out.println("Stem constructor");
	 }
	    
	 public static void main(String[] args) {
	    Stem s = new Stem();
	}
}
