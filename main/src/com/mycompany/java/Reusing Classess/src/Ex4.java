/*
* Chứng Minh Constructor Của Class Cơ Sở Luôn Được Gọi Trước Constructor Của Class Dẫn Xuất
* */

public class Ex4 {
    /*
    * import static net.mindview.util.Print.*;

class Art {
    Art() { print("Art constructor"); }
}

class Drawing extends Art {
    Drawing() { print("Drawing constructor"); }
}

public class Cartoon extends Drawing {
    public Cartoon() { print("Cartoon constructor"); }

    public static void main(String[] args) {
        Cartoon x = new Cartoon(); // Tạo đối tượng của Cartoon
    }
}
* Output: Art constructor
Drawing constructor
Cartoon constructor
*
* Giải thích:

Constructor của class cơ sở Art được gọi đầu tiên,
* sau đó là Drawing,
* và cuối cùng là Cartoon.
* Điều này chứng minh rằng các constructor của class cơ sở luôn được gọi trước các constructor của class dẫn xuất.
    * */
}
