package giuaki;

import giuaki.ContinuousSignal;
import giuaki.DiscreteSignal;
import giuaki.Radar;
import giuaki.Signal;

public class Main {
	 public static void main(String[] args) {
	     int[] discreteValues = {1, 0, 0, 1}; 
	     Signal discreteSignal = new DiscreteSignal(discreteValues);
	     discreteSignal.displaySignal();

	     Signal continuousSignal = new ContinuousSignal(3.5);
	     continuousSignal.displaySignal();
	     
	     Radar radar = new Radar();
	        int[] analyzedSignal = radar.analyzeSignal(4);
	        radar.displaySignal(analyzedSignal);
	 }
}
