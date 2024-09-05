public class InitializationAndCleanupExercise8 {

    public void method1() {
        method2();
        this.method2();
    }

    public void method2() {
        System.out.println("method 2");
    }
    public static void main(String[] args) {
        InitializationAndCleanupExercise8 obj = new InitializationAndCleanupExercise8();
        obj.method1();
    }
}
//Nó hoạt động giống nhau việc sử dụng this chỉ để chỉ rõ nó thuộc về đối tượng hiện tại