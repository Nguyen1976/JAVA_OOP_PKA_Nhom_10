

class Derived extends Base {
	//Constructor của lớp cha được gọi trước constructor của lớp con
    public Derived() {
        System.out.println("Derived constructor");
    }
    public static void main(String[] args) {
    	Derived d = new Derived();

	}
}