package Ex8;

public class Derived extends Base{
    public Derived(){
        super("Base");
        System.out.println("Derived");
    }

    public Derived(String message){
        super(message);
        System.out.println("Derived constructor: " + message);
    }
}
