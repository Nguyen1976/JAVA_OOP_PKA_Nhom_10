class A {
    A() {
        System.out.println("Constructor of A");
    }
}

class B {
    B() {
        System.out.println("Constructor of B");
    }
}

class C extends A {
    // Thành viên của lớp B
    B b = new B(); 
    // Không tạo constructor cho lớp C
}

public class Test {
	public static void main(String[] args) {
		C c = new C();
	}
}
