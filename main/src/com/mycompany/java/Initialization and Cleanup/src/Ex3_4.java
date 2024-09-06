class MyClass{
    MyClass(){
        System.out.println("Hello");
    }

    MyClass(String a){
        System.out.println("Thong bao: " + a);
    }
}
public class Ex3_4 {
    public static void main(String[] args) {
        MyClass myObj = new MyClass();
        MyClass myObj2 = new MyClass("Hello");
    }


}
