import java.util.*;
import java.util.function.*;

public class FunctionLab {
	public static void main(String args[]) {
		Function<Integer, Integer> inc = x -> x + 1;
		int y = inc.apply(7);
		System.out.println(y);

		assert inc.apply(10) == 11;

		Function<Integer, Integer> square = x -> x * x;
		assert square.apply(8) == 64;

		Function<String, Integer> len = s -> s.length();
		assert len.apply("Happy days") == 10;

		Function<Integer, Boolean> pos = x -> x > 0 ? true : false;
		assert pos.apply(-5) == false;

		Function<List<Integer>, Integer> sum = ls -> {
			int sm = 0;
			for (Integer x : ls)
				sm += x;
			return sm;
		};

		List<Integer> lst = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		assert sum.apply(lst) == 45;

		Function<List<Integer>, List<Integer>> getEven = ls -> {
			List<Integer> tmp = new ArrayList<>();
			for (Integer x : ls)
				if (x % 2 == 0)
					tmp.add(x);
			return tmp;
		};
		assert getEven.apply(lst).equals(Arrays.asList(2, 4, 6, 8));

		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		assert add.apply(4, 9) == 13;

		Predicate<Integer> pos1 = x -> x > 0 ? true : false;
		assert pos1.test(-5) == false;

		Predicate<List<Integer>> allPos = ls -> {
			for (Integer x : ls)
				if (x <= 0)
					return false;
			return true;
		};
		assert allPos.test(lst) == true;

		BiFunction<Function<Integer, Integer>, Integer, Integer> testFunc = (f, x) -> f.apply(x);

		assert testFunc.apply(x -> x + 1, 6) == 7;
		assert testFunc.apply(x -> x - 1, 6) == 5;
		assert testFunc.apply(x -> x * x, 6) == 36;
		assert testFunc.apply(x -> x * x + x - 1, 6) == 41;
		assert testFunc.apply(square, 6) == 36;

		MyListInt mls = new MyListInt(Arrays.asList(1, 2, 3, 4, 5, 6));
		assert mls.contains(x -> x < 2);
		assert mls.contains(x -> x > 1 && x < 5);
		assert mls.contains(x -> x > 6) == false;

		assert mls.get(x -> x % 2 == 0).equals(Arrays.asList(2, 4, 6));
		assert mls.get(x -> x < 4).equals(Arrays.asList(1, 2, 3));

		lst.forEach(x -> System.out.print(x + " "));
		lst.removeIf(x -> x % 2 == 0);
		System.out.println();
		lst.forEach(x -> System.out.print(x + " "));
	}
}

class MyListInt {
	private List<Integer> data;

	public MyListInt(List<Integer> ls) {
		data = new ArrayList<>();
		data.addAll(ls);
	}

	public boolean contains(Integer x) {
		return data.contains(x);
	}

	public boolean contains(Predicate<Integer> pred) {
		for (Integer x : data)
			if (pred.test(x))
				return true;
		return false;
	}

	public List<Integer> get(Predicate<Integer> pred) {
		List<Integer> tmp = new ArrayList<>();
		for (Integer x : data)
			if (pred.test(x))
				tmp.add(x);
		return tmp;
	}
}
