package package1;

public class ParentClass {
	//proted không thể truy cập từ ngoài và phải thông qua kế thừa extends
	protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }
}
