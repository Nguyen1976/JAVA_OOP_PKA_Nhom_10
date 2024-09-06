package Ex16_Ex17;

public class Main {
    public static void main(String[] args) {
        Frog frog = new Frog();

        // Upcast đối tượng Frog thành Amphibian
        Amphibian amphibian = frog;

        // Gọi các phương thức từ Amphibian (thực tế là đang gọi qua Frog)
        amphibian.swim();
        amphibian.walk();
        amphibian.makeVoice();
    }
}
