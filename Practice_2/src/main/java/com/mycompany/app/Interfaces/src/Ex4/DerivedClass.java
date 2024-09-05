package Ex4;

public class DerivedClass extends BaseClass{
//    //Phương thức đặc biệt trong lớp dẫn xuất
//    public void show(){
//        System.out.println("DerivedClass: show() method called");
//    }
// Ghi đè phương thức show()
    @Override
    public void show() {
        System.out.println("DerivedClass: show() method called");
    }
}
