
public class Frog extends Amphibian {
	// Phương thức của lớp kế thừa
    public void croak() {
        System.out.println("Frog croaking");
    }
    
    public static void main(String[] args) {
    	Frog frog = new Frog();
    	frog.swim();
        frog.jump();
        frog.eat();
        frog.croak();
        
        //upcast
        Amphibian amphibian = frog;//gán đối tượng frog cho biến amphibian có kiểu Amphibian.
        amphibian.swim();
        amphibian.jump();
        amphibian.eat();
        //amphibian.croak(); 
        //// Không thể gọi phương thức croak() vì amphbian là Amphibian, không phải Frog
	}
}
