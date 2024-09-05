class BaseClass {
    // Phương thức final không thể bị ghi đè
    public final void finalMethod() {
        System.out.println("BaseClass.finalMethod()");
    }
}

class SubClass extends BaseClass {
    // Cố gắng ghi đè phương thức final (sẽ gây lỗi biên dịch)
    // @Override
    // public void finalMethod() {
    //     System.out.println("SubClass.finalMethod()");
    // }
}
public class FinalMethodTest {
	public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.finalMethod(); // Gọi phương thức từ lớp cơ sở

        // Không thể gọi phương thức ghi đè vì lớp SubClass không thể ghi đè phương thức final
        // subClass.finalMethod(); // Nếu phương thức ghi đè không được bình luận, sẽ gây lỗi biên dịch
    }
}
