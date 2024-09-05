// Lớp cha Cycle
class Cycle {
    public void ride() {
        System.out.println("Riding a cycle");
    }
    // Phương thức trả về số lượng bánh xe
    public int wheels() {
        return 0; // Lớp cơ sở trả về 0 bánh xe, các lớp con sẽ ghi đè phương thức này
    }
}

class Unicycle extends Cycle {
    @Override
    public void ride() {
        System.out.println("Riding a unicycle");
    }
    
    @Override
    public int wheels() {
        return 1; // Unicycle có 1 bánh xe
    }
}

// Lớp con Bicycle
class Bicycle extends Cycle {
    @Override
    public void ride() {
        System.out.println("Riding a bicycle");
    }
    
    @Override
    public int wheels() {
        return 2; // Unicycle có 1 bánh xe
    }
}

// Lớp con Tricycle
class Tricycle extends Cycle {
    @Override
    public void ride() {
        System.out.println("Riding a tricycle");
    }
    
    @Override
    public int wheels() {
        return 3; // Tricycle có 3 bánh xe
    }
}

public class Main {
	 public static void main(String[] args) {
		 Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};

	     for (Cycle cycle : cycles) {
	    	 cycle.wheels(); // Kiểm tra phương thức ride() cho các loại Cycle khác nhau
	     }
	 }
}
