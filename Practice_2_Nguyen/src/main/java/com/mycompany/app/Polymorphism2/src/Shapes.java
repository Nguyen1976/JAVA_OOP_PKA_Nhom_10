
public class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] s = new Shape[9];

        // Điền vào mảng với các hình ngẫu nhiên
        for (int i = 0; i < s.length; i++)
            s[i] = gen.next();

        // Gọi các phương thức đa hình
        for (Shape shp : s)
            shp.draw();
    }
}