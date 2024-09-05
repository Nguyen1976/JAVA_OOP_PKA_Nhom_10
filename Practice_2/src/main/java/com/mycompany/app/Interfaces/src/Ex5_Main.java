import implementation.MyImplementation;

public class Ex5_Main {
    public static void main(String[] args) {
        // Tạo đối tượng của lớp MyImplementation
        MyImplementation myImpl = new MyImplementation();
        // Gọi các phương thức từ MyInterface đã được triển khai
        myImpl.methodOne();
        myImpl.methodTwo();
        myImpl.methodThree();
    }
}
