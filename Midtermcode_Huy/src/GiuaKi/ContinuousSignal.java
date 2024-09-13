package GiuaKi;

public class ContinuousSignal implements Signal{
    private double bienDo;
    private  double buocSong;

    public ContinuousSignal(double bienDo, double buocSong) {
        this.bienDo = bienDo;
        this.buocSong = buocSong;
    }


    @Override
    public void displaySignal(){
        System.out.println("Tin hieu lien tuc: Bien do: " + bienDo + ", buoc song: " + buocSong);
    }
}
