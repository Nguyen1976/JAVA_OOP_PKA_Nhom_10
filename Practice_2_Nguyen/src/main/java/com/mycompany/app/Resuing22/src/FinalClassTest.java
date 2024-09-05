// Lớp final không thể bị kế thừa
final class FinalClass {
    public void display() {
        System.out.println("This is a final class.");
    }
}

//Lớp con cố gắng kế thừa lớp final (lỗi)
//class SubClass extends FinalClass { 
//  // Không thể kế thừa từ lớp FinalClass
//}

public class FinalClassTest {
	public static void main(String[] args) {
        FinalClass fc = new FinalClass();
        fc.display();
    }
}
