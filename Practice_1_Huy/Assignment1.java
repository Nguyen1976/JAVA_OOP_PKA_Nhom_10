package JAVA_OOP_PKA_Nhom_10.Practice_1;

public class Assignment1 {
    public static void main(String[] args) {
        Number n1 = new Number(); //tao doi tuong Number moi gan bien cho n1
        Number n2 = new Number(); //tao doi tuong Number moi gan bien cho n2
        n1.i = 2; // gan gia tri 2 cho bien i cua doi tuong n1
        n2.i = 5;  // gan gia tri 5 cho bien i cua doi tuong n2
        n1.i = n2.i; // gan gia tri cua n2.i cho n1.i -> n1.i duoc gan gtri 5
        n2.i = 10; // thay doi gia tri cua n2.i = 10
        System.out.println(n1.i);
        //khi gan n1.i = n2.i thi gtri cua n1.i = 5. thay doi n2.i k lam anh huong den gtri cua n1.i
    }
}
