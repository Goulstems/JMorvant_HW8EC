import java.util.LinkedHashMap;

public class rangeFunctions {
	// Slide 3 alg
	public static int range1(int[] numbers) {
	    int maxDiff = 0;     // look at each pair of values
	    for (int i = 0; i < numbers.length; i++) {
	        for (int j = 0; j < numbers.length; j++) {
	            int diff = Math.abs(numbers[j]-numbers[i]);
	            if (diff > maxDiff) {
	                maxDiff = diff;
	            }
	        }
	    }
	    return maxDiff;
	}
	
	// Slide 4 alg
	public static int range2(int[] numbers) {
	    int maxDiff = 0;     // look at each pair of values
	    for (int i = 0; i < numbers.length; i++) {
	        for (int j = i + 1; j < numbers.length; j++) {
	            int diff = Math.abs(numbers[j]-numbers[i]);
	            if (diff > maxDiff) {
	                maxDiff = diff;
	            }
	        }
	    }
	    return maxDiff;
	}
	
	// Slide 5 alg
	public static int range3(int[] numbers) {
	    int max = numbers[0];     // find max/min values
	    int min = max;
	    for (int i = 1; i < numbers.length; i++) {
	        if (numbers[i] < min) {
	            min = numbers[i];
	        }
	        if (numbers[i] > max) {
	            max = numbers[i];
	        }
	    }
	    return max - min;
	}
	
	// Method to fit given inputSize into array
	public static int[] fill(int inputSize) {
		int[] input = new int[inputSize];
		for (int i =0;i<inputSize;i++) {
			input[i]=i;
		}
		return input;
	}
	
	// Method to test given range func with given inputSize sets
	public static LinkedHashMap<Integer,Long> testHelper(int rangeFunc, int[] inputSizeSet) {
		LinkedHashMap<Integer,Long> results = new LinkedHashMap<Integer,Long>();
		for (int input : inputSizeSet) {
			int[] rawInput=fill(input);
			long before = System.currentTimeMillis();
			if (rangeFunc==1) {
				range1(rawInput);
			} else if (rangeFunc==2) {
				range2(rawInput);
			} else if (rangeFunc==3) {
				range3(rawInput);
			} 
			long after = System.currentTimeMillis();
			long delta = after-before;
			results.put(input,delta);
			//fill results with deltatime
		}
		return results;
	}
}
