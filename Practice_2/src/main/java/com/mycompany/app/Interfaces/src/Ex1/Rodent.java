package Ex1;

public abstract class Rodent {
    // Phương thức trừu tượng bắt buộc các lớp con phải triển khai
    public abstract void eat();

    public abstract void sleep();

    public abstract void makeSound();

    public void run(){
        System.out.println("Rodent is running."); // Phương thức không trừu tượng
    }
}
