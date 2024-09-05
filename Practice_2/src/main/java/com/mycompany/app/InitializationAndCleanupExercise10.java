public class InitializationAndCleanupExercise10 {
    
    public void finalize() {
        System.out.println("Nguyen dep trai");
    }
    public static void main(String[] args) {
        InitializationAndCleanupExercise10 obj = new InitializationAndCleanupExercise10();
        obj.finalize();
    }
}
//finalize() là một phương thức đặc biệt trong Java và nó được ghi đè để in thông báo