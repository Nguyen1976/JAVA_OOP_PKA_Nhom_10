package giuaki;

public class ContinuousSignal implements Signal {
	private double amplitude;//lưu giá trị biên độ của tín hiệu liên tục

	 public ContinuousSignal(double amplitude) {
	     this.amplitude = amplitude;
	 }

	 //được cài đặt từ interface signal hiển thị biên độ liên tục
	 @Override
	 public void displaySignal() {
	     System.out.println("Continuous Signal with amplitude: " + amplitude);
	 }
	 
}
