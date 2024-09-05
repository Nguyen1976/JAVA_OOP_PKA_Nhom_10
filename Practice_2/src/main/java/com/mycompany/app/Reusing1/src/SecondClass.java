
public class SecondClass {
	//Hiểu là tạo đối tựng từ SimpleClass
	private SimpleClass simpleObject;//simpleObject được khai báo với kiểu SimpleClass
	
	//Tham chiếu đến SimpleClass
	//Phương thức có kiểu trả về là SimpleClass
	public SimpleClass getSimpleObject() {
        if (simpleObject == null) {
            simpleObject = new SimpleClass("Đối tượng khởi tạo lười biếng");
        }
        return simpleObject;
    }
	
	
	public static void main(String[] args) {
		 SecondClass second = new SecondClass();
		 
		 second.getSimpleObject().printName();
	}
}
