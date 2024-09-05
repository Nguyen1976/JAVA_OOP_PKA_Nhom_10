package Ex13;

public class ImplementingClass implements CombinedInterface{
    @Override
    public void baseMethod() {
        System.out.println("Implementing baseMethod.");
    }

    @Override
    public void methodA() {
        System.out.println("Implementing methodA.");
    }

    @Override
    public void methodB() {
        System.out.println("Implementing methodB.");
    }

    @Override
    public void combinedMethod() {
        System.out.println("Implementing combinedMethod.");
    }

    public static void main(String[] args) {
        ImplementingClass obj = new ImplementingClass();
        obj.baseMethod();
        obj.methodA();
        obj.methodB();
        obj.combinedMethod();
    }
}
