package Ex7;

public class C extends A_7 {
    B b;
    public C(String s, int n){
        super(s); //Goi constructor cua A;
        b = new B(n);//Khoi tao thanh vien B
        System.out.println("C constructor");
    }
}
