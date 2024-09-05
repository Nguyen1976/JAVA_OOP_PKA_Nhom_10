package Ex3;

public class TestPrint {
    public static void main(String[] args) {
        // Tạo đối tượng của lớp Derived và gọi phương thức print()
        Derived derived = new Derived();
        System.out.println("Calling print() from main:");
        derived.print();
    }
}
