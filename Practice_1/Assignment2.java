package JAVA_OOP_PKA_Nhom_10.Practice_1;

public class Assignment2 {
    
    public static void main(String[] args) {
        Number n1 = new Number();
        Number n2 = new Number();
        n1.i = 2;
        n2.i = 5;
        n1 = n2; // n1 n2 deu tham chieu den cung 1 doi tuong
        n2.i = 10;// what is n1.i? = 10
        n1.i = 20;// what is n2.i? = 20
    }
    
}
