/*
*Chứng minh rằng class cơ sở được khởi tạo trước khi constructor của class dẫn xuất có thể truy cập,
* và ngay cả khi bạn không tạo constructor cho Cartoon,
* trình biên dịch sẽ tự động tạo một constructor mặc định gọi constructor của class cơ sở.
* */
public class Ex3 {
/*
* import static net.mindview.util.Print.*;

class Art {
    Art() { print("Art constructor"); }
}

class Drawing extends Art {
    Drawing() { print("Drawing constructor"); }
}

public class Cartoon extends Drawing {
    // Không có constructor nào được định nghĩa cho Cartoon
    public static void main(String[] args) {
        Cartoon x = new Cartoon(); // Tạo một đối tượng của Cartoon
    }
}
*
*
* Khi Cartoon được khởi tạo, constructor mặc định được trình biên dịch tự động tạo ra vì không có constructor nào được định nghĩa rõ ràng.
Constructor này sẽ tự động gọi constructor của class cơ sở Drawing, và sau đó Drawing sẽ gọi constructor của Art.
*  Điều này chứng minh rằng quá trình khởi tạo diễn ra từ class cơ sở ra ngoài.
* */
}
