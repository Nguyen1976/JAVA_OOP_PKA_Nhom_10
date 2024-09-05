//Lớp cơ sở là loài gặm nhấm
class Rodent {
	void eat() {
		System.out.println("Roden is eating");
	}
}

class Mouse extends Rodent {
	@Override
	void eat() {
		System.out.println("Roden is eating");
	}
}

class Gerbil extends Rodent {
    @Override
    void eat() {
        System.out.println("Gerbil is eating seeds.");
    }
}

public class Main {
	public static void main(String[] args) {
		Rodent[] rodent = new Rodent[2];
		rodent[0] = new Mouse();
		rodent[1] = new Gerbil();
		
		for(Rodent r: rodent) {
			r.eat();
		}
	}
}
