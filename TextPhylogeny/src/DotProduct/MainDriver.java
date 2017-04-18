package DotProduct;

import java.util.List;
import java.util.Map;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DotProduct dp = new DotProduct();
		List<String> first = dp.GetWords("Document1.txt");
		List<String> second = dp.GetWords("Document2.txt");
		Map<String, Integer> map1 = dp.ComputeFrequency(first);
		Map<String, Integer> map2 = dp.ComputeFrequency(second);
		System.out.println(dp.ComputeDistance(map1, map2));
	}

}
