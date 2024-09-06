class Dog{
    void bark(){
        System.out.println("binh thuong");
    }
    void bark(int time){
        System.out.println("Sua" + time + "time");
    }
    void bark(double to){
        System.out.println("sua to: " + to);
    }
    void bark(char kieu){
        System.out.println("sua: " + kieu);
    }
    void bark(boolean isAngry){
        System.out.println(isAngry ? "angry" : "calm");
    }
}
public class Ex5 {
    public static void main(String[] args) {
        Dog dog = new Dog();

        dog.bark();
        dog.bark(3);
        dog.bark(9.0);
        dog.bark('a');
        dog.bark(true);
    }
}
