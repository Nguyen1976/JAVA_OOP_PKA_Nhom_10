package Ex7;

public class Main {
    public static void main(String[] args) {
        Rodent[] rodents = { new Mouse(), new Gerbil(), new Hamster() };

        for (Rodent rodent : rodents) {
            rodent.eat();
            rodent.sleep();
            rodent.run();
            System.out.println("---");
        }
    }
}
