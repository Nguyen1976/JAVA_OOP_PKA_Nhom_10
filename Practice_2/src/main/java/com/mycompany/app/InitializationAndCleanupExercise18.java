public class InitializationAndCleanupExercise18 {
    public InitializationAndCleanupExercise18(String type) {
        System.out.println("doi so duoc truyen vao la: " + type);
    }
    public static void main(String[] args) {
        InitializationAndCleanupExercise18[] arr = new InitializationAndCleanupExercise18[5];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = new InitializationAndCleanupExercise18("Doi so thu " + (i + 1)); 
        }
    }
}
