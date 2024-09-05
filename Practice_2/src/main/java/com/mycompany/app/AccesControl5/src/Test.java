
public class Test {
	public static void main(String[] args) {
		MyClass obj = new MyClass();
		
		System.out.println("Public: " + obj.publicField);
//		System.out.println("Private: " + obj.privateField); Lỗi biên dịch
		System.out.println("Protected: " + obj.protectedField);//Có thể truy cập vì cùng gói
		System.out.println("Package-Access: " + obj.packageAccessField); // Có thể truy cập (vì cùng gói)
		
        obj.publicMethod(); // Có thể gọi
        // obj.privateMethod(); // Lỗi biên dịch
        obj.protectedMethod(); // Có thể gọi (vì cùng gói)
        obj.packageAccessMethod(); // Có thể gọi (vì cùng gói)
	}
}
