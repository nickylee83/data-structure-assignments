import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Lambda2 {
	static Function<Integer, Integer> inc = x -> x + 1;
	static BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
	static Function<Integer, Integer> chkInt = x -> x >= 0 ? x + 1 : x + 2;
	static Function<List<Integer>, Integer> sumList = lst -> {
		int s = 0;
		for (Integer x : lst) {
			s = s + x;
		}
		return s;
	};
	static Function<List<Integer>, Boolean> allPositive = lst -> {
		for (Integer x : lst) {
			if (x <= 0) {
				return false;
			}
		}
		return true;
	};

	static BiFunction<Integer,List<Integer>, Integer> myCounter = (k,lst) -> {
		int freq = 0;
		for (Integer x : lst) {
			if(k.equals(x)) {
				freq++;
			}
		}
		return freq;
	};

	public static void main(String[] args) {
		System.out.println(inc.apply(5));
		System.out.println(add.apply(2, 4));
		System.out.println(chkInt.apply(0));
		System.out.println(chkInt.apply(-2));
		System.out.println(sumList.apply(Arrays.asList(1, 2, 3, 4)));
		System.out.println(allPositive.apply(Arrays.asList(1, 2, 3, 4)));
		System.out.println(myCounter.apply(4, Arrays.asList(1,2,3,4,4)));
	}
}
