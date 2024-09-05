
public class ConnectionManager {
	private static final int MAX_CONNECTIONS = 10;//lưu số lượng tối đa connection
    private static Connection[] connections = new Connection[MAX_CONNECTIONS];//1 mảng đối tượng connection lưu trữ tối đa 10 dsdoosi tượng
    private static int currentIndex = 0;

    //chỉ chạy đúng 1 lần
    static {
        // Tạo các đối tượng Connection và lưu vào mảng
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            connections[i] = Connection.createConnection();
        }
    }

    // Phương thức tĩnh để lấy Connection
    public static Connection getConnection() {
        if (currentIndex < MAX_CONNECTIONS) {
            return connections[currentIndex++];
        } else {
            return null; // Không còn Connection nào
        }
    }
    
    public static void main(String[] args) {
    	for (int i = 0; i < 12; i++) {
            Connection conn = ConnectionManager.getConnection();
            if (conn != null) {
                System.out.println("Connection " + (i + 1) + " acquired.");
            } else {
                System.out.println("No more connections available.");
            }
        }
	}
}
