import Ex15.Base;

public class Derived_Ex15 extends Base {
    // Gọi phương thức protected từ trong class dẫn xuất
    public void CallProtected(){
        protectedMethod();// Có thể gọi được vì Derived kế thừa từ Base
    }

    public static void main(String[] args) {
        Derived_Ex15 derived_ex15 = new Derived_Ex15();
        derived_ex15.CallProtected();
    }
}
