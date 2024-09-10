package GiuaKi;

public class Main {
    public static void main(String[] args) {
        //tao doi tuong tin hieu roi rac
        DiscreteSignal discreteSignal = new DiscreteSignal(5.0, 100.0);
        discreteSignal.displaySignal();

        //tao doi tuong tin hieu lien tuc
        ContinuousSignal continuousSignal= new ContinuousSignal(3.5, 0.005);
        continuousSignal.displaySignal();

        Radar radar = new Radar();
        System.out.println("Phan tich tin hieu: ");
        for (int n = 0; n <= 15; n++){
            double ketqua = radar.phanTichTinHieu(n);
            System.out.println("X(" + n + ") = " + ketqua);
        }
        //kiem tra tinh toan tin hieu roi rac

        double discreteResult = discreteSignal.tinhTinHieu(4);
        System.out.println("tinh tin hieu voi n = 4: " + discreteResult);

    }
}
