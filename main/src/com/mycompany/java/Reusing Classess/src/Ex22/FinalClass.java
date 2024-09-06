package Ex22;

public final class FinalClass {
    public void display(){
        System.out.println("this is a final class");
    }
}

//Lớp con cố gắng kế thừa lớp final (lỗi)
//class SubClass extends FinalClass {
//  // Không thể kế thừa từ lớp FinalClass
//}