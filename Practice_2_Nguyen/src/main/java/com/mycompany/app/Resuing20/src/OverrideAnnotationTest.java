class WithFinals {
	// Phương thức private final (không thể ghi đè)
    private final void f() { 
    	System.out.println("WithFinals.f()"); 
    }
    
    // Phương thức private (cũng không thể ghi đè)
    private void g() { 
    	System.out.println("WithFinals.g()"); 
    }
}

class OverridingPrivate extends WithFinals {
    // Phương thức private final (không ghi đè, tạo mới)
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }
    // Phương thức private (cũng không ghi đè, tạo mới)
    private void g() {
        System.out.println("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {
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

public class OverrideAnnotationTest {
	public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f(); // Sẽ gọi phương thức f() từ OverridingPrivate2
        op2.g(); // Sẽ gọi phương thức g() từ OverridingPrivate2

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
