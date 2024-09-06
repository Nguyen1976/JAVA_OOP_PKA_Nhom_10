class Example{
    boolean active = false;// Biến trạng thái của đối tượng
    // Constructor nhận tham số để thiết lập trạng thái
    Example (boolean state){
        active = state;
    }

    // Phương thức để thiết lập lại trạng thái
    void activate(){
        active = false;
    }

    // Phương thức finalize kiểm tra trạng thái khi đối tượng bị thu dọn
    @Override
    protected void finalize(){
        if (active){
            System.out.println("Error: object is still active!");
        }
    }
}
public class Ex10 {
    public static void main(String[] args) {
        // Tạo đối tượng và thử nghiệm
        Example obj1 = new Example(true);
        // Thực hiện cleanup hợp lý
        obj1.activate();

        // Tạo đối tượng khác và quên không cleanup
        new Example(true);

        // Yêu cầu Garbage Collector chạy
        System.gc();

    }
}
