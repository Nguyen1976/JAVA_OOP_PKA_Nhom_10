package Ex20;

public class OverrideAnnotationTest {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();// Sẽ gọi phương thức f() từ OverridingPrivate2
        op2.g();// Sẽ gọi phương thức g() từ OverridingPrivate2

        // Có thể upcast
        //OverridingPrivate op = op2;
        //op.f(); // Lỗi biên dịch nếu không ghi đè chính xác
        //op.g(); // Lỗi biên dịch nếu không ghi đè chính xác

        // Có thể upcast thêm nữa
        //WithFinals wf = op2;
        // wf.f(); // Lỗi biên dịch nếu không ghi đè chính xác
        // wf.g(); // Lỗi biên dịch nếu không ghi đè chính xác
    }
}
