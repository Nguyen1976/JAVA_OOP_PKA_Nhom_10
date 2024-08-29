public class InitializationAndCleanupExercise11 {
    
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("finalize duoc goi");
        } finally {
            super.finalize(); // Đảm bảo gọi phương thức finalize() của lớp cha
        }
    }
    public static void main(String[] args) {
        InitializationAndCleanupExercise11 obj = new InitializationAndCleanupExercise11();
        obj = null; // Giảm tài nguyên bộ nhớ
        System.gc(); // Yêu cầu garbage collector thu hồi đối tượng
    }
}
