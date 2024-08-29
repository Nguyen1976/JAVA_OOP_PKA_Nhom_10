public class InitializationAndCleanupExercise16 {
    String[] arr = {"a", "b", "c", "d", "e"};
    public static void main(String[] args) {
        InitializationAndCleanupExercise16 obj = new InitializationAndCleanupExercise16();
        // for (int i = 0; i < obj.arr.length; i++) {
        //     System.out.println(obj.arr[i]);
        // }

        for(String element: obj.arr) {
            System.out.println(element);
        }
    }
}
