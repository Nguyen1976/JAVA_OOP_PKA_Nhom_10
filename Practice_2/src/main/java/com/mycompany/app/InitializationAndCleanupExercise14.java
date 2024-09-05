public class InitializationAndCleanupExercise14 {
    static String s1 = "Duoc khoi tao khi dinh nghiz";

    static String s2;

    static {
        s2 = "Duoc khoi tao boi khoi tinh";
    }

    static void print() {
        System.out.println(s1);
        System.out.println(s2);
    }

    public static void main(String[] args) {
        print();   
    }
}