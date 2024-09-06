package Ex19;

public class FinalReference {
    // Blank final reference: không được khởi tạo tại đây
    private final Ex19 ex19;

    // Constructor khởi tạo blank final
    public FinalReference(int val){
        ex19 = new Ex19(val);// Khởi tạo blank final trong constructor
    }

    // Constructor khác khởi tạo blank final với giá trị mặc định
    public FinalReference(){
        ex19 = new Ex19(0); // Khởi tạo blank final với giá trị mặc định
    }

    public void useEx19(){
        ex19.printValue();
    }
}
