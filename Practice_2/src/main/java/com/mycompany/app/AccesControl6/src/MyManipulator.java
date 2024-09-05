
public class MyManipulator {
	public void manipulateData() {
		MyClass obj = new MyClass();
		
		System.out.println("Before Manipulation: " + obj.protectedData);
        obj.protectedData = 20; // Thay đổi giá trị
        System.out.println("After Manipulation: " + obj.protectedData);
	}
	
	public static void main(String[] args) {
		MyManipulator obj = new MyManipulator();
		obj.manipulateData();//Dữ liệu đã bị thay đổi
	}
}
