
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.*;

public class Lambda {

	public static void main(String[] args) {
		System.out.println(inc.apply(7));
		System.out.println(even.apply(9));
		System.out.println(pos.apply(-1));
		System.out.println(abs.apply(-5));
		System.out.println(sum.apply(4));
		System.out.println(add.apply(3, 5));
		ArrayList<Integer> dt = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println(allPos.apply(dt));
	}

	static Function<Integer, Integer> inc = x -> x + 1;
	static Function<Integer, Boolean> even = x -> x % 2 == 0;
	static Function<Integer, Boolean> pos = x -> x > 0;
	static Function<Integer, Integer> abs = x -> x >= 0 ? x : -x;
	static Function<Integer, Integer> sum = n -> {
		int s = 0;
		for (int j = 0; j < n; j++) {
			s = s + (j + 1);
		}
		return s;
	};
	static BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
	static Function<ArrayList<Integer>,Boolean> allPos = lst -> {
		for(Integer x:lst) {
			if(x <= 0) return false;
		}
		return true;		
	};
}
