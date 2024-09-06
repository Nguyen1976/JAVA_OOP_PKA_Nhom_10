//Create a class containing an uninitialized String reference. Demonstrate
//that this reference is initialized by Java to null.
public class Ex1 {
    // Khai báo một tham chiếu String chưa được khởi tạo
    String chuoi;

    public static void main(String[] args) {
        Ex1 ex = new Ex1();
        System.out.println("Gia tri " + ex.chuoi);
    }
}
//gia tri cua chuoi la null vi Java se gan null cho bien tham chieu chua dc khoi tao
