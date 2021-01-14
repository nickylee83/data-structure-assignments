
/* 
Complete the insertion sort function first and then compare the two functions by analysing 
their performance by using benchmarking. Complete the report below. 


Report ===================================
 What type of CPU: Intel Core i5 - 3230M 4 CPUs
 Amount of Memory: 8GB
 Speed of processor: 2.60GHz
Test1 (First try)
Data size: N =100000
data randomly generated based on N
Cost Insertion Sort : 4954 ms 
Cost Selection Sort : 4054 ms

Data size: N =100000
data randomly generated based on N
Repeated 10 times: average costs
Cost Insertion Sort : 2781 ms 
Cost Selection Sort : 4060 ms
** Comparative analysis based on data

Data size: N = 50000
data randomly generated based on N (average costs of repeated 20 times)
Cost Insertion Sort : 542 ms 
Cost Selection Sort : 1018 ms

according to the above tests, selection sort was faster only in the first few times and
on average cost, insertion sort was faster than selection sort.

best case scenario, 10 trials
data size N = 100000 (Not randomised) all elements in ascending order
Average Cost Insertion Sort : 0 ms 
Average Cost Selection Sort : 1795 ms

worst case scenario, 10 trials
data size N = 100000 (Not randomised) all elements in reverse order
Average Cost Insertion Sort : 4770 ms 
Average Cost Selection Sort : 4209 ms
*/
import java.util.*;

public class SortingLab1 {
	static int N = 100000;

	public static void main(String args[]) {
		
		int dt[] = new int[N];
		long insertionSum = 0;
		long selectionSum = 0;

		// selectionSort =================================
		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < N; j++) {
				dt[j] = (int) (Math.random() * N);
			}

			long start = System.currentTimeMillis();
			selectionSort(dt);
			long end = System.currentTimeMillis();
			System.out.println("SelectionSort cost:" + (end - start));

			selectionSum += end - start;
			System.out.println(isSorted(dt));
			
			// insertionSort ==================================
			for (int j = 0; j < N; j++)
				dt[j] = (int) (Math.random() * N);
			start = System.currentTimeMillis();
			insertionSort(dt);
			end = System.currentTimeMillis();
			System.out.println("InsertionSort cost:" + (end - start));
			System.out.println(isSorted(dt));

			insertionSum += end - start;
		}
		insertionSum = insertionSum / 10;
		System.out.println("Average insertion sort cost: " + insertionSum);

		selectionSum = selectionSum / 10;
		System.out.println("Average selection sort cost: " + selectionSum);

	}

	static boolean isSorted(int k[]) {
		for (int j = 0; j < k.length - 1; j++)
			if (k[j] > k[j + 1])
				return false;
		return true;
	}

	static void selectionSort(int k[]) {
		int i = 0;
		while (i < k.length) {
			int t = i;
			int j = i + 1;
			while (j < k.length) {
				if (k[t] > k[j])
					t = j;
				j++;
			}
			int temp = k[i];
			k[i] = k[t];
			k[t] = temp;
			i++;
		}
	}

	static void insertionSort(int k[]) {
		int j = 1;
		while (j < k.length) {
			int i = j;
			while (i > 0 && k[i] < k[i - 1]) {
				int temp = k[i];
				k[i] = k[i - 1];
				k[i - 1] = temp;
				i = i - 1;
			}
			j = j + 1;
		}
	}
}