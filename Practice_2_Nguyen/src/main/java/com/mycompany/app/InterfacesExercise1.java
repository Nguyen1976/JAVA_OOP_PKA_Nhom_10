public class InterfacesExercise1 {
    String s1;

    public void displayS1() {
        if(s1 == null) {
            System.out.println("s1 is null");
        } else {
            System.out.println("s1 is not null");
        }
    }

    public static void main(String[] args) {
        InterfacesExercise1 obj = new InterfacesExercise1();
        obj.displayS1();
    }
}
