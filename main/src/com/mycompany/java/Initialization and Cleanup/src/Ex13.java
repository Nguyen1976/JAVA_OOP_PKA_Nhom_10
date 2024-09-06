class Cup{
    Cup(int marker){
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker){
        System.out.println("f(" + marker + ")");
    }
}

class Cups{
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
        System.out.println("Static initializer of cups");
    }

    Cups(){
        System.out.println("Cups()");
    }
}
public class Ex13 {
    public static void main(String[] args) {
        Cups.cup1.f(99);


//        Cups cups = new Cups();
    }
}
