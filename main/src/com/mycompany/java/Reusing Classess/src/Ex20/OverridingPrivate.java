package Ex20;

public class OverridingPrivate extends WithFinals{
    // Phương thức private final (không ghi đè, tạo mới)
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }
    // Phương thức private (cũng không ghi đè, tạo mới)
    private void g() {
        System.out.println("OverridingPrivate.g()");
    }
}
