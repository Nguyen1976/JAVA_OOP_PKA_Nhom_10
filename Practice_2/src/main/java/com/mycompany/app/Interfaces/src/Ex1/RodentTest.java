package Ex1;

public class RodentTest {
    public static void main(String[] args) {
        // Tạo mảng chứa các đối tượng Rodent với các lớp con khác nhau
        Rodent[] rodents = {new Mouse(), new Gerbil(), new Hamster()};

        // Duyệt qua mảng và gọi các phương thức chung
        for (Rodent rodent : rodents) {
            rodent.eat();
            rodent.sleep();
            rodent.makeSound();
            rodent.run();
            System.out.println("-----------");
        }
    }
}
