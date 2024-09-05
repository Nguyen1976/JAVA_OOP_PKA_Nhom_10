package package2;

import package1.ParentClass;

public class TestClass extends ParentClass {
    public void test() {
        // Có thể gọi phương thức protected vì TestClass kế thừa từ ParentClass
        protectedMethod();
    }
    public static void main(String[] args) {
    	TestClass obj = new TestClass();
    	obj.test();
	}
}