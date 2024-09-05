public class InitializationAndCleanupExercise4 {
    public InitializationAndCleanupExercise4() {
        System.out.println("Ham tao mac dinh duoc tao");
    }

    public InitializationAndCleanupExercise4(String value) {
        System.out.println(value);
    }
    public static void main(String[] args) {
        InitializationAndCleanupExercise4 obj1 = new InitializationAndCleanupExercise4();
        InitializationAndCleanupExercise4 obj2 = new InitializationAndCleanupExercise4("Ham tao qua tai duoc tao");
    }
}
