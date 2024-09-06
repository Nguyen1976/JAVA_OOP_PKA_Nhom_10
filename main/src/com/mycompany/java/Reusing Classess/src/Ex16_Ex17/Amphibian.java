package Ex16_Ex17;
/*
* Tạo một class tên Amphibian.
Từ class Amphibian, tạo một class kế thừa có tên Frog.
Đặt các phương thức phù hợp vào class cơ sở Amphibian.
Trong phương thức main(), tạo một đối tượng Frog, upcast nó thành Amphibian,
* và chứng minh rằng tất cả các phương thức vẫn hoạt động.
*
* Upcasting trong Java là quá trình chuyển đổi một đối tượng từ kiểu con sang kiểu cha của nó.
*  Khi một đối tượng của lớp con được gán cho biến của lớp cha, quá trình này được gọi là upcasting.
*
* Upcasting: Cho phép đối xử với đối tượng thuộc lớp dẫn xuất (subclass) như thể nó thuộc lớp cơ sở (base class).
* Điều này rất hữu ích khi muốn tận dụng tính đa hình và giảm độ phức tạp trong việc xử lý các đối tượng.
Phương pháp này chứng minh rằng các phương thức được định nghĩa trong class cơ sở vẫn có thể được sử dụng một cách đầy đủ
*  ngay cả khi upcast đối tượng của class dẫn xuất.
* */
public class Amphibian {
    public void swim(){
        System.out.println("swim");
    }
    public void walk(){
        System.out.println("walk");
    }
    public void makeVoice(){
        System.out.println("make voice");
    }
}
