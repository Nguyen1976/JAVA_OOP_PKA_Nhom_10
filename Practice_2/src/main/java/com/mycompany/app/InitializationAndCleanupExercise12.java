public class InitializationAndCleanupExercise12 {
    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.empty();
        tank.fill();
        tank = null;//tank khong duoc su dung tức là k còn được tham chiếu đến Tank
        System.gc();

        try {
            Thread.sleep(1000);//tạm dùng luồng hiện tại để có cơ hooij thực hiện System.gc()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
