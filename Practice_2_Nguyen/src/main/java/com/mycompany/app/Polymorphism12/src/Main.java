//Lớp cơ sở là loài gặm nhấm
class Rodent {
	void eat() {
		System.out.println("Roden is eating");
	}
	Rodent() {
		System.out.println("Rodent()"); // Thông báo khi khởi tạo lớp cơ sở
    }
}

class Mouse extends Rodent {
	@Override
	void eat() {
		System.out.println("Roden is eating");
	}
	Mouse() {
		 System.out.println("Mouse()"); // Thông báo khi khởi tạo lớp con
	}
}

class Gerbil extends Rodent {
    @Override
    void eat() {
        System.out.println("Gerbil is eating seeds.");
    }
    Gerbil() {
    	System.out.println("Gerbil()"); // Thông báo khi khởi tạo lớp con
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

//Giải thích: Khi tạo đối tượng của lớp con, trước tiên, hàm khởi tạo của lớp cơ sở (Rodent) sẽ được gọi. Điều này đảm bảo rằng tất cả các thành viên từ lớp cơ sở được khởi tạo trước khi lớp con bắt đầu khởi tạo.
