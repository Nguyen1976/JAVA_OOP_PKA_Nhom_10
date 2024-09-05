//Lớp cơ sở là loài gặm nhấm
class Rodent {
	private Shared shared;
	
	Rodent(Shared shared) {
		this.shared = shared;
        this.shared.addRef();
        System.out.println("Creating " + this);
    }
	
	protected void dispose() {
		System.out.println("Dispose" + this);
	}
	
	public String toString() { 
		return "Rodent"; 
	}
}

class Mouse extends Rodent {
	public Mouse(Shared shared) {
        super(shared);
        System.out.println("Creating " + this);
    }
    
    public String toString() { 
    	return "Mouse"; 
    }
}

class Gerbil extends Rodent {
	public Gerbil(Shared shared) {
        super(shared);
        System.out.println("Creating " + this);
    }
    
    public String toString() { 
    	return "Gerbil"; 
    }
}

public class Main {
	public static void main(String[] args) {
		Shared shared = new Shared();
		Rodent[] rodent = new Rodent[2];
		rodent[0] = new Mouse(shared);
		rodent[1] = new Gerbil(shared);
		
		for(Rodent r: rodent) {
			System.out.println(r);
			r.dispose();
		}
		
		// Thực hiện thêm một lần để đảm bảo tất cả đối tượng đều được dọn dẹp
		System.gc();
        
        try { 
            Thread.sleep(500); // Cho hệ thống ngủ để đảm bảo việc dọn dẹp hoàn thành
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }
	}
}

//Giải thích: Khi tạo đối tượng của lớp con, trước tiên, hàm khởi tạo của lớp cơ sở (Rodent) sẽ được gọi. Điều này đảm bảo rằng tất cả các thành viên từ lớp cơ sở được khởi tạo trước khi lớp con bắt đầu khởi tạo.
