public class InitializationAndCleanupExercise1 {
    String s1;

    public void displayS1() {
        if(s1 == null) {
            System.out.println("s1 is null");
        } else {
            System.out.println("s1 is not null");
        }
    }

    public static void main(String[] args) {
        InitializationAndCleanupExercise1 obj = new InitializationAndCleanupExercise1();
        obj.displayS1();
    }
}
