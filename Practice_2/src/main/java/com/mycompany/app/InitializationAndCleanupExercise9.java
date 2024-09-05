public class InitializationAndCleanupExercise9 {
    //Hàm tạo 1
    public InitializationAndCleanupExercise9() {
        this("Nguyen dep trai");
    } 
    
    //Hàm tạo 2
    public InitializationAndCleanupExercise9(String message) {
        System.out.println("Ham tao 2");
        System.out.println(message);
    } 

    public static void main(String[] args) {
        InitializationAndCleanupExercise9 obj = new InitializationAndCleanupExercise9();
    }
}
