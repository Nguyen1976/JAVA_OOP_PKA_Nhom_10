public class Assignment2 {
    public static void main(String[] args) {
        // Tạo hai đối tượng MyNumber
        MyNumber n1 = new MyNumber();
        MyNumber n2 = new MyNumber();

        // Gán giá trị cho thuộc tính 'i' của đối tượng n1 và n2
        n1.i = 2;
        n2.i = 5;

        // Gán đối tượng n2 cho n1. Bây giờ n1 và n2 tham chiếu cùng một đối tượng.
        n1 = n2;

        // Thay đổi giá trị thuộc tính 'i' của đối tượng n2 (và n1, vì chúng cùng tham chiếu)
        n2.i = 10;

        // Thay đổi giá trị thuộc tính 'i' của đối tượng n1 (cũng thay đổi giá trị thuộc tính 'i' của n2)
        n1.i = 20;

        // In giá trị thuộc tính 'i' của n2 ra màn hình
        System.out.println(n2.i); // n2.i = 20
    }
}