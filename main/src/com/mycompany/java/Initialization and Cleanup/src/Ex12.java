class Tank{
    private boolean isEmpty; // tao bien trang thai cua tank

    Tank(){
        isEmpty = true;// mac dinh Tank trong
    }

    void fill(){
        isEmpty= false;
        System.out.println("Tank dc fill");
    }

    void empty(){
        isEmpty = true;
        System.out.println("Tank trong");
    }

    @Override
    protected void finalize() throws Throwable{
        if (!isEmpty){
            System.out.println("Loi: Tank chua trong khi don dep");
        }
        else {
            System.out.println("Tank da trong khi don dep");
        }
        super.finalize();
    }
}

public class Ex12 {
    public static void main(String[] args) {
        Tank tank1 = new Tank();
        tank1.fill();

        tank1 = null; //Mat tham chieu, san sang cho GC

        //Yeu cau Garbage Collector chay
        System.gc();

        System.out.println("Chuong trinh dang ket thuc");

        //TH Tank trong
        Tank tank2 = new Tank();
        tank2.fill();
        tank2 = null;

        System.gc();
    }
}
