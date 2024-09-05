class Component1 {
    Component1(String message) {
        System.out.println("Component1 constructor with message: " + message);
    }
}

class Component2 {
    Component2(int number) {
        System.out.println("Component2 constructor with number: " + number);
    }
}

class Component3 {
    Component3(double value) {
        System.out.println("Component3 constructor with value: " + value);
    }
}

class Root {
    Component1 c1;
    Component2 c2;
    Component3 c3;

    Root(String c1Message, int c2Number, double c3Value) {
        // Khởi tạo các đối tượng của các component với đối số
        c1 = new Component1(c1Message);
        c2 = new Component2(c2Number);
        c3 = new Component3(c3Value);
        System.out.println("Root constructor");
    }
}

class Stem extends Root {
		Component1 c1;
	    Component2 c2;
	    Component3 c3;

	    Stem(String c1Message, int c2Number, double c3Value) {
	        // Khởi tạo các đối tượng của các component với đối số và gọi constructor của lớp Root
	        super(c1Message, c2Number, c3Value);
	        c1 = new Component1(c1Message);
	        c2 = new Component2(c2Number);
	        c3 = new Component3(c3Value);
	        System.out.println("Stem constructor");
	    }
	    public static void main(String[] args) {
	        // Tạo đối tượng của lớp Stem với các đối số cho các component
	        Stem s = new Stem("Hello", 42, 3.14);
	    }
}
