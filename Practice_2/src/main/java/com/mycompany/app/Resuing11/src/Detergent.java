
public class Detergent {
	private Cleaner cleaner = new Cleaner();
	//cho phép lớp Detergent sử dụng các phương thức của Cleaner mà không cần phải kế thừa từ Cleaner
    public void scrub() {
        cleaner.scrub(); // Delegation
    }

    public void dilute() {
        cleaner.dilute(); // Delegation
    }

    public void apply() {
        cleaner.apply(); // Delegation
    }
    
    public void clean() {
        scrub();
        dilute();
        apply();
    }
    
    public static void main(String[] args) {
    	Detergent detergent = new Detergent();
        detergent.clean();
	}
}
