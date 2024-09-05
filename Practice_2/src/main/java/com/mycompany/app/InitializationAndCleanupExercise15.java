public class InitializationAndCleanupExercise15 {
    // Trường String được khởi tạo thông qua khối khởi tạo instance
    String instanceField;

    {
        instanceField = "Duoc khoi tao thong qua khoi tao instance";
    }

    // Phương thức để in giá trị của trường instance
    public void printField() {
        System.out.println("instanceField: " + instanceField);
    }

    public static void main(String[] args) {
        InitializationAndCleanupExercise15 obj = new InitializationAndCleanupExercise15();
        obj.printField();
    }
}
