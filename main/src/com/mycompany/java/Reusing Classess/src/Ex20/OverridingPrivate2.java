package Ex20;

public class OverridingPrivate2 extends OverridingPrivate{
    // Sử dụng @Override để ghi đè phương thức của lớp cơ sở (khi có thể)
    @Override
    public void f() {
        System.out.println("OverridingPrivate2.f()");
    }

    @Override
    public void g() {
        System.out.println("OverridingPrivate2.g()");
    }
}
