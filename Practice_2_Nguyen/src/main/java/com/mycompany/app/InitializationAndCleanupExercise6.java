public class InitializationAndCleanupExercise6 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark(3d);
        dog.bark(3);
    }
}

//Điều này chứng tỏ rằng các phương thức quá tải với hai tham số, dù theo thứ tự ngược lại nhau, đã hoạt động hiệu quả và đã được gọi đúng cách.
