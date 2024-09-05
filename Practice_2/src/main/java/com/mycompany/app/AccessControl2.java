
import AccessControl2class.*;

public class AccessControl2 {
	public AccessControl2() {
        System.out.println("class chinh");
    }

    public static void main(String[] args) {
    	AccessControl2 obj = new AccessControl2();
    	
    	// Sử dụng tên đầy đủ của lớp để tránh xung đột
        AccessControl2class.AccessControl2 obj2 = new AccessControl2class.AccessControl2();
    }
}
