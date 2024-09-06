//class Example2 {
//    boolean active = false; // Biến trạng thái của đối tượng
//
//    // Constructor nhận tham số để thiết lập trạng thái
//    Example2(boolean state) {
//        active = state;
//    }
//
//    // Phương thức để thiết lập lại trạng thái
//    void deactivate() {
//        active = false;
//    }
//
//    // Phương thức finalize kiểm tra trạng thái khi đối tượng bị thu dọn
//    @Override
//    protected void finalize() {
//        if (active) {
//            System.out.println("Error: object is still active!");
//        }
//    }
//
//    // Phương thức thủ công để gọi finalize() đảm bảo nó được gọi
//    void callFinalize() {
//        try {
//            finalize();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }
//}
//public class Ex11 {
//    public static void main(String[] args) {
//        // Tạo đối tượng và thử nghiệm
//        Example2 obj1 = new Example2(true);
//        // Thực hiện cleanup hợp lý
//        obj1.deactivate();
//
//        // Gọi trực tiếp finalize để đảm bảo nó được chạy
//        obj1.callFinalize();
//
//        // Tạo đối tượng khác và quên không cleanup
//        Example obj2 = new Example(true);
//
//        // Gọi trực tiếp finalize để đảm bảo nó được chạy
//        obj2.callFinalize();
//
//        // Yêu cầu Garbage Collector chạy, chỉ để kiểm thử
//        System.gc();
//    }
//}
