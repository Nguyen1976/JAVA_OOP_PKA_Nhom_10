// Lớp cha Cycle
class Cycle {
    public void ride() {
        System.out.println("Riding a cycle");
    }
}

class Unicycle extends Cycle {
    @Override
    public void ride() {
        System.out.println("Riding a unicycle");
    }
}

// Lớp con Bicycle
class Bicycle extends Cycle {
    @Override
    public void ride() {
        System.out.println("Riding a bicycle");
    }
}

// Lớp con Tricycle
class Tricycle extends Cycle {
    @Override
    public void ride() {
        System.out.println("Riding a tricycle");
    }
}

public class Main {
	 public static void main(String[] args) {
		 // Khởi tạo các đối tượng của các lớp con
		 //Trong phương thức main(), ta tạo các đối tượng của từng lớp con, nhưng upcast chúng về lớp cha Cycle.
		 //Phương thức ride() sẽ được gọi trên các đối tượng đã upcast và thực hiện hành vi tương ứng của từng lớp con.
		 //Khi gọi phương thức ride phương thức của lớp con sẽ được sử dụng nhờ cơ chế đa hình
	     Cycle unicycle = new Unicycle();
	     Cycle bicycle = new Bicycle();
	     Cycle tricycle = new Tricycle();
	        
	     // Gọi phương thức ride() trên các đối tượng đã upcast
	     unicycle.ride();  // Output: Riding a unicycle
	     bicycle.ride();   // Output: Riding a bicycle
	     tricycle.ride();  // Output: Riding a tricycle
	    }
}
