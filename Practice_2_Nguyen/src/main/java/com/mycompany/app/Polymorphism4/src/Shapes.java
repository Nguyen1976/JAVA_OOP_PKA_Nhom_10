
public class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] s = new Shape[10];

        // Điền vào mảng với các hình ngẫu nhiên
        for (int i = 0; i < s.length; i++)
            s[i] = gen.next();

        // Vẫn hoạt động bình thường
        //Khi không ghi đè newMethod() trong các lớp con, tất cả các đối tượng sẽ gọi phương thức từ lớp cha.
        for (Shape shp : s)
//            shp.draw();
        	shp.newMethod();
    }
}