package GiuaKi;

public class DiscreteSignal implements Signal{
    private double bienDo;
    private double tinhThuongXuyen;

    public DiscreteSignal(double bienDo, double tinhThuongXuyen) {
        this.bienDo = bienDo;
        this.tinhThuongXuyen = tinhThuongXuyen;
    }

    //Hien thi tin hieu
//    @Override
//    public void displaySignal(){
//        System.out.println("Tin hieu roi rac: Bien do = " + bienDo + ", tinh thuong xuyen = " + tinhThuongXuyen);
//    }

    public double tinhTinHieu(int n){
        double result = 0;
        for(int k = Integer.MIN_VALUE; k <=Integer.MAX_VALUE; k++){
            result += x(k) * delta(n - k);
        }
        return result;
    }

    private double x(int k){
        return 1.0;//gan tam x = 1
    }

    //ham tao day xung don vi
    private int delta(int n){
        return (n== 0) ? 1 : 0;
    }

    @Override
    public void displaySignal(){
        System.out.println("Hien thi tin hieu roi rac");
    }
}
