public class Tank {
    private boolean isFull;

    public Tank() {
        isFull = false; //Tank là trống
    }

    public void fill() {
        isFull = true; //Tank đã đầy
        System.out.println("tank duoc lap day");
    }

    public void empty() {
        isFull = false; //Tank đã trống
        System.out.println("tank duoc rong");
    }

    @Override
    protected void finalize() throws Throwable {
        //protected Bảo Mật: finalize() có thể được ghi đè bởi các lớp con, nhưng không thể được truy cập từ các lớp khác ngoài package trừ khi lớp con cụ thể
        try {
            if (isFull) {
                System.out.println("err: tank k duoc lam trong");
            } else {
                System.out.println("tank dang trong");
            }
        } finally {
            super.finalize(); 
        }
    }

}
