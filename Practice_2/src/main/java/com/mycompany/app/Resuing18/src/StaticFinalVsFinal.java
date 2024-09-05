
public class StaticFinalVsFinal {
	public static final int STATIC_FINAL_VALUE = 100;//Không thể thay đổi giá trị
	
	public final int finalValue;//có giá trị không thể thay đổi nhưng có giá trị khác nhau với từng đối tượng được khởi tạo
	
	public StaticFinalVsFinal(int value) {
        this.finalValue = value;
    }
	
	public static void main(String[] args) {
		System.out.println("STATIC_FINAL_VALUE: " + StaticFinalVsFinal.STATIC_FINAL_VALUE);
		
		StaticFinalVsFinal obj1 = new StaticFinalVsFinal(200);
        StaticFinalVsFinal obj2 = new StaticFinalVsFinal(300);
        
        System.out.println("obj1.finalValue: " + obj1.finalValue);
        System.out.println("obj2.finalValue: " + obj2.finalValue);
	}
}
