package Ex21;

public class FinalMethodTest {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.finalMethod();// Gọi phương thức từ lớp cơ sở

        // Không thể gọi phương thức ghi đè vì lớp SubClass không thể ghi đè phương thức final
        // subClass.finalMethod(); // Nếu phương thức ghi đè không được bình luận, sẽ gây lỗi biên dịch
    }
}
