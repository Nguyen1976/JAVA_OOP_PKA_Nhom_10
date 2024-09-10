package giuaki;

public class DiscreteSignal implements Signal{
	//đại diện cho tín hiệu rời rạc và 1 mảng các giá trị signalValues
	private int[] signalValues;

	 public DiscreteSignal(int[] values) {
		 //nhận 1 mảng giá trị rời rạc khởi tạo đối tượng
	     this.signalValues = values;
	 }
	 
	 //phương thức tính giá trị của tín hiệu rời rạc x(n)
	 public int computeSignal(int n) {
        int result = 0;
        for (int k = 0; k < signalValues.length; k++) {
            result += signalValues[k] * delta(n - k);
        }
        return result;
    }

    //phương thức để mô phỏng hàm delta (dãy xung đơn vị)
    private int delta(int n) {
        return (n == 0) ? 1 : 0;
    }
	
	// Hiển thị kết quả của tín hiệu tại các điểm
	public void displayComputedSignal(int n) {
		System.out.println("Computed Signal x(" + n + ") = " + computeSignal(n));
	}

    //hiển thị tín hiệu rời rạc
    @Override
    public void displaySignal() {
        for (int i = 0; i < signalValues.length; i++) {
            System.out.println("Discrete Signal x(" + i + ") = " + signalValues[i]);
        }
    }
}
