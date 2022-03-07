import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RangeEvaluationTest extends rangeFunctions {
	
	public static void TEST(int algToTest) {
		int sizeSetFactor = 7;
		if (algToTest==3) {sizeSetFactor=19;}
		int[] inputSizeSet = new int[sizeSetFactor];
		int n=1000;
		for (int i=0;i<sizeSetFactor;i++) {
			inputSizeSet[i]=n;
			n*=2;
		}
		LinkedHashMap<Integer,Long> results = testHelper(algToTest,inputSizeSet);
		System.out.println("[ALG"+algToTest+"]");
		for (Map.Entry<Integer,Long> result : results.entrySet()) {
			System.out.println("\t"+result.getKey()+" inputs takes "+result.getValue()+"ms");
		}
	}
	
	public static void main(String[] args) {
		TEST(1);
		TEST(2);
		TEST(3);
	}
}
