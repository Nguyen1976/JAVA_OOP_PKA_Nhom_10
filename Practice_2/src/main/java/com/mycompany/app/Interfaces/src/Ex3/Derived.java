package Ex3;

public class Derived extends Base{
    private int value = 10;

    // Ghi đè phương thức print() để in giá trị của biến value
    @Override
    public void print(){
        System.out.println("Derived print(): value = " + value);
    }
}
