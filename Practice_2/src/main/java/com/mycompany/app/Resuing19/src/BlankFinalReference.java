class Poppet {
    private int i;
    Poppet(int ii) { 
    	i = ii; 
    }
    
    @Override
    public String toString() {
        return "Poppet with i = " + i;
    }
}

public class BlankFinalReference {
	private final Poppet finalReference;
	
	// Constructor 1: Khởi tạo finalReference
	public BlankFinalReference(int value) {
        finalReference = new Poppet(value); // Khởi tạo tham chiếu final
        System.out.println("Constructor 1: finalReference initialized to " + finalReference);
    }
	
	 // Constructor 2: Khởi tạo finalReference
    public BlankFinalReference() {
        finalReference = new Poppet(0); // Khởi tạo tham chiếu final
        System.out.println("Constructor 2: finalReference initialized to " + finalReference);
    }
    
    public static void main(String[] args) {
    	// Tạo đối tượng với constructor có tham số
        BlankFinalReference obj1 = new BlankFinalReference(42);

        // Tạo đối tượng với constructor không có tham số
        BlankFinalReference obj2 = new BlankFinalReference();
	}
}
