package Ex12;

public class Adventure {
    public static void t(CanFight x) { x.fight(); }
    public static void u(CanSwim x) { x.swim(); }
    public static void v(CanFly x) { x.fly(); }
    public static void w(ActionCharacter x) { x.fight(); }
    public static void x(CanClimb x) { x.climb(); } // Thêm phương thức để kiểm tra CanClimb

    public static void main(String[] args) {
        Hero h = new Hero();
    }
}
