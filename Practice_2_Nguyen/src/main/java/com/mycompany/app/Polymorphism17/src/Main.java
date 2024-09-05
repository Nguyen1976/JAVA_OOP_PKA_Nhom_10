class Cycle {
    public void ride() { 
    	System.out.println("Ride Cycle"); 
    }
}

class Unicycle extends Cycle {
    public void ride() { 
    	System.out.println("Ride Unicycle"); 
    }
    
    public void balance() { 
    	System.out.println("Unicycle balance"); 
    }
}

class Bicycle extends Cycle {
    public void ride() { 
    	System.out.println("Ride Bicycle"); 
    }
    
    public void balance() { 
    	System.out.println("Bicycle balance"); 
  
    }
}

public class Main {
	public static void main(String[] args) {
        Cycle[] cycles = {
            new Unicycle(),
            new Bicycle(),
        };

        // Gọi balance() trên mỗi phần tử của mảng
        for (Cycle cycle : cycles) {
            // Sử dụng phương thức balance() nếu có
            // Downcasting để gọi balance() trên Unicycle và Bicycle
            if (cycle instanceof Unicycle) {
                ((Unicycle) cycle).balance();
            } else if (cycle instanceof Bicycle) {
                ((Bicycle) cycle).balance();
            } else {
                System.out.println("No balance method available");
            }
        }
    }
}
