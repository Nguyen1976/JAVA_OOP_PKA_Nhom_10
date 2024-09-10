package giuaki;

public class Main {
	 public static void main(String[] args) {
		 //tín hiệu rời rạc với giá trị 1,0,0,1
	     int[] discreteValues = {1, 0, 0, 1}; 
	     
	     Signal discreteSignal = new DiscreteSignal(discreteValues);
	     discreteSignal.displaySignal();
	     
	     //tạo 1 tín hiệu liên tục với biên độ là 3.5
	     Signal continuousSignal = new ContinuousSignal(3.5);
	     continuousSignal.displaySignal();
	     
	     //Tạo một đối tượng Radar, sau đó gọi phương thức analyzeSignal(4) để phân tích tín hiệu và lưu kết quả vào mảng analyzedSignal. Cuối cùng, hiển thị kết quả phân tích.
	     Radar radar = new Radar();
	        int[] analyzedSignal = radar.analyzeSignal(4);
	        radar.displaySignal(analyzedSignal);
	 }
}
