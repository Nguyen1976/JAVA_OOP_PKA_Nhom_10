package test;

import mypackage.MyClass;
import mypackage.MyDerivedClass;;

public class Test {
	public static void main(String[] args) {
		MyClass obj = new MyClass();
		
		MyDerivedClass obj2 = new MyDerivedClass();
		
		obj2.callProtectedMethod(); 	
	}
}
