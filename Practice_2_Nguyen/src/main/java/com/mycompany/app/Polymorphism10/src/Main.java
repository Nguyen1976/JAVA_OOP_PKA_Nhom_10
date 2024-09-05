//Lớp cơ sở
class Base {
	void firstMethod() {
		System.out.println("Base: firstMethod()");
		secondMethod();
	}
	
	void secondMethod() {
		System.out.println("Base: secondMethod()");
	}
}

class Derived extends Base {
	@Override
	void secondMethod() {
		System.out.println("Derived: secondMethod()");
	}
}

public class Main {
	public static void main(String[] args) {
		Base obj = new Derived();//Đối tượng của lớp con với kiểu Base
		obj.firstMethod();
		//Ban đầu Base chạy và firstMethod gọi secondMethod nhưng secondMethod bị ghi đè
	}
}
