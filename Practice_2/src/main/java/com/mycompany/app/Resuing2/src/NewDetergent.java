
public class NewDetergent extends Detergent {
	
	@Override
	public void scrub() {
		System.out.println("Scrub in NewDetergent");
	}
	
	 public void sterilize() {
		 System.out.println("Sterilize in NewDetergent");
	 }
	 
	 public static void main(String[] args) {
		 NewDetergent newDetergent = new NewDetergent();
		 newDetergent.scrub();
		 newDetergent.sterilize();
	}
}
