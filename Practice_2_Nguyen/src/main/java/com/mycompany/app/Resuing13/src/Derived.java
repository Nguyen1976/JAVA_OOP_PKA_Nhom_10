class Base {
    // Phương thức overload đầu tiên
    void method(int a) {
        System.out.println("Base method(int a): " + a);
    }

    // Phương thức overload thứ hai
    void method(double a) {
        System.out.println("Base method(double a): " + a);
    }

    // Phương thức overload thứ ba
    void method(String a) {
        System.out.println("Base method(String a): " + a);
    }
}

public class Derived extends Base {
	void method(int a, int b) {
		System.out.println("Derived method(int a, int b): " + a + ", " + b);
	}
	public static void main(String[] args) {
		Derived obj = new Derived();

        // Gọi tất cả các phương thức overload từ lớp Base
        obj.method(10);           // Gọi method(int a)
        obj.method(10.5);         // Gọi method(double a)
        obj.method("Hello");     // Gọi method(String a)

        // Gọi phương thức overload mới từ lớp Derived
        obj.method(10, 20);      // Gọi method(int a, int b)
	}
}
