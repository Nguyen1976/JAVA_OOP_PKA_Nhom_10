package Ex4;

public class TestDowncast {
//    // Phương thức tĩnh ép kiểu từ BaseClass xuống DerivedClass và gọi show()
//    public static void callShow(BaseClass base){
//        // Ép kiểu đối tượng base về DerivedClass
//        if(base instanceof DerivedClass){
//            DerivedClass derived = (DerivedClass) base;
//            derived.show();
//        }else {
//            System.out.println("Downcast failed. Object is not of type DerivedClass.");
//        }
//    }
//
//    public static void main(String[] args) {
//        //Tao doi tuong DerivedClass
//        DerivedClass derivedClass = new DerivedClass();
//        // Gọi phương thức callShow() với tham chiếu BaseClass
//        callShow(derivedClass);
//    }
// Bây giờ không cần ép kiểu vì BaseClass đã có phương thức trừu tượng show()
    public static void callShow(BaseClass base) {
        base.show(); // Gọi trực tiếp phương thức show() từ tham chiếu BaseClass
    }

        public static void main(String[] args) {
            // Tạo đối tượng DerivedClass
            DerivedClass derived = new DerivedClass();
            // Gọi phương thức callShow() với tham chiếu BaseClass
            callShow(derived);
        }
}

//Ban Đầu Ép Kiểu (Downcasting): Ban đầu, chúng ta cần ép kiểu đối tượng base từ BaseClass thành DerivedClass để có thể gọi phương thức show().
// Đây là vì BaseClass không biết về phương thức show().
//
//Loại Bỏ Ép Kiểu: Sau khi thêm phương thức trừu tượng show() vào BaseClass, không cần ép kiểu nữa vì BaseClass đã định nghĩa rằng các lớp dẫn xuất phải triển khai phương thức show().
// Điều này làm mã rõ ràng và an toàn hơn, đồng thời tránh được lỗi runtime do ép kiểu sai.
