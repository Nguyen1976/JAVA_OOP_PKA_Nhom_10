class A {
    A(String message) {
        System.out.println("Constructor of A: " + message);
    }
}

class B {
    B(int number) {
        System.out.println("Constructor of B with number: " + number);
    }
}

class C extends A {
    // Thành viên của lớp B
    B b;

    // Constructor của lớp C
    C(String aMessage, int bNumber) {
        super(aMessage); // Gọi constructor của lớp A với đối số
        b = new B(bNumber); // Khởi tạo thành viên của lớp B
        System.out.println("Constructor of C");
    }
}

public class Main {
	public static void main(String[] args) {
        // Tạo đối tượng của lớp C với các đối số cho lớp A và B
        C c = new C("Hello from A", 42);
    }
}
