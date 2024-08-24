class MyNumber {
    public int i; // Thuộc tính 'i' của lớp MyNumber
}

public class Assignment1 {
    public static void main(String[] args) {
        // Tạo hai đối tượng MyNumber
        MyNumber n1 = new MyNumber();
        MyNumber n2 = new MyNumber();
        
        // Gán giá trị cho thuộc tính 'i' của đối tượng n1 và n2
        n1.i = 2;
        n2.i = 5;
        
        // Gán giá trị thuộc tính 'i' của n2 cho thuộc tính 'i' của n1
        n1.i = n2.i;
        
        // Thay đổi giá trị thuộc tính 'i' của đối tượng n2
        n2.i = 10;
        
        // In giá trị thuộc tính 'i' của đối tượng n1 ra màn hình
        System.out.println(n1.i); // n1.i = 5
    }
}