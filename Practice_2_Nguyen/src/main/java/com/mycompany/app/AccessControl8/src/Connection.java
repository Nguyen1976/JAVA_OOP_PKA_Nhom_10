
public class Connection {
	private static int count = 0;
	
	private Connection() {
		//Không được tạo đối tượng từ bên ngoài
	}
	
	public static int getCount() {
		return count;
	}
	
	//có thể gọi createConnection thay vì tạo 1 đối tượng cụ thể
	static Connection createConnection() {
        if (count < 10) {
            count++;
            return new Connection();
        } else {
            return null;
        }
    }
}
