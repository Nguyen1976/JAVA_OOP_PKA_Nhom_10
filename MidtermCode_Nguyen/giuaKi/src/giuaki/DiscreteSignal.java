package giuaki;

public class DiscreteSignal implements Signal{
	//đại diện cho tín hiệu rời rạc và 1 mảng các giá trị signalValues
	private int[] signalValues;

	 public DiscreteSignal(int[] values) {
		 //nhận 1 mảng giá trị rời rạc khởi tạo đối tượng
	     this.signalValues = values;
	 }

	 @Override
	 public void displaySignal() {
		 //hiển thị từng giá trị của tín hiệu rời rạc
	     for (int value : signalValues) {
	         System.out.println("Discrete Signal: " + value);
	     }
	 }
}
