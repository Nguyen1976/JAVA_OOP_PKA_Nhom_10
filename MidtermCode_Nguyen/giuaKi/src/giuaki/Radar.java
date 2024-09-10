package giuaki;

public class Radar {
	//phương thức để phân tích và tạo ra 1 mảng tín hiệu
	public int[] analyzeSignal(int n) {
		//tạo ra mảng signal gồm 16 phần tử
		//chứa các giá trị được tính toán dựa trên biểu thức 1-i/15
        int[] signal = new int[16];
        for (int i = 0; i < 16; i++) {
            if (i <= 15) {
                
                signal[i] = (int) Math.round(1 - (i / 15.0));
            } else {
                signal[i] = 0;
            }
        }
        return signal;
    }

    public void displaySignal(int[] signal) {
    	//hiển thị từng giá trị tín hiệu
        for (int value : signal) {
            System.out.println("Radar signal: " + value);
        }
    }
}
