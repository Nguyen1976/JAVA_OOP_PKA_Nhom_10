package JAVA_OOP_PKA_Nhom_10.Practice_1;

public class PassObject {
    static void f(Number m){ //phuong thuc
        m.i = 15;
    }

    public static void main(String[] args) {
        Number n = new Number();
        n.i = 14;
        f(n); //n.i = 15 do gọi lai phuong thuc f o tren
        System.out.println(n.i);
    }
}
