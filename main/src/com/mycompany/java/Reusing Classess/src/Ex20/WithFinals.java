package Ex20;

public class WithFinals {
    // Phương thức private final (không thể ghi đè)
    private final void f() {
        System.out.println("WithFinals.f()");
    }

    // Phương thức private (cũng không thể ghi đè)
    private void g() {
        System.out.println("WithFinals.g()");
    }
}
