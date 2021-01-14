/*
Assignment 4

Student name: Myo Thet Tun
Student number: 2918551
===========================================================================

Your task this week is to benchmark three fast sorting algorithms Mergesort,
Quicksort and Arrays.sort (that uses the dual-pivot quicksort described in Yaroslavskiy 2009)


Please note that marks will be awarded based on the "quality" of the report written by you
in the sections provided below. 

Be Careful: Submit your own work, do not copy/paste anything written by someone else.

*/

/*=======================================================================================
*  Benchmarking Report for each of the sorting algorithms
*  
 Type of CPU: Intel Core i5 - 3230M 4 CPUs
 Amount of Memory: 8GB
 Speed of processor: 2.60GHz
=========================================================================================
*   MergeSort
*	
	Data size: N = 10000000
	data randomly generated based on N
	Repeated 10 times: average costs
	Cost Merge Sort : 1929 ms
	
*  =======================================================================================
*   QuickSort
*	
*	Data size: N = 10000000
	data randomly generated based on N
	Repeated 10 times: average costs
	Cost Quick Sort : 1349 ms
*
* ========================================================================================
*  Arrays.sort
*
*	Data size: N = 10000000
	data randomly generated based on N
	Repeated 10 times: average costs
	Cost Quick Sort : 1033 ms
*
*
* ========================================================================================
*  Comparison based on your test results
* 	
* 	According to the above tests, Arrays.sort was the fastest, QuickSort comes second and
	MergeSort was the slowest.
	
	best case scenario, 10 trials
	data size N = 10000000 (Not randomised) all elements in ascending order
	Average Cost Merge Sort : 662 ms 
	Average Cost Quick Sort : 3 ms
	Average Cost Arrays.sort : 9 ms

*
*
*/
//=====================================================================================  

import java.util.*;

class Assignment4_2018 {
	static int N = 10000000;

	public static void main(String args[]) {

		int dt[] = new int[N];
		long mergeSum = 0;
		long quickSum = 0;
		long arraySum = 0;

		// ==========================================================
		// Benchmarking MergeSort code
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < N; j++) {
				dt[j] = (int) (Math.random() * N);
			}

			long start = System.currentTimeMillis();
			mergeSort(dt, 0, N);
			long end = System.currentTimeMillis();
			System.out.println("\nMergeSort cost: " + (end - start));

			mergeSum += end - start;
			System.out.println(isSorted(dt));

			// ==========================================================
			// Benchmarking QuickSort code

			for (int j = 0; j < N; j++) {
				dt[j] = (int) (Math.random() * N);
			}

			start = System.currentTimeMillis();
			quickSort(dt, 0, N);
			end = System.currentTimeMillis();
			System.out.println("QuickSort cost: " + (end - start));

			quickSum += end - start;
			System.out.println(isSorted(dt));
			// ==========================================================
			// Benchmarking Arrays.sort

			for (int j = 0; j < N; j++) {
				dt[j] = (int) (Math.random() * N);
			}

			start = System.currentTimeMillis();
			Arrays.sort(dt);
			end = System.currentTimeMillis();
			System.out.println("Arrays.sort cost: " + (end - start));

			arraySum += end - start;
			System.out.println(isSorted(dt));
		}

		mergeSum = mergeSum / 10;
		System.out.println("\nAverage merge sort cost: " + mergeSum);

		quickSum = quickSum / 10;
		System.out.println("Average quick sort cost: " + quickSum);

		arraySum = arraySum / 10;
		System.out.println("Average Arrays.sort cost: " + arraySum);
		// ==========================================================
	}

	static void quickSort(int f[], int p, int q) {
		if (q - p <= 1)
			; // skip
		else {
			int x;
			int i, j, k;
			// let x = middle element in f[p..q-1]
			x = f[(p + q) / 2];
			// x = f[p];
			i = p;
			j = p;
			k = q;
			while (j != k) {
				if (f[j] == x)
					j = j + 1;
				else if (f[j] < x) { // swap f[j] with f[i]
					int temp;
					temp = f[j];
					f[j] = f[i];
					f[i] = temp;
					j = j + 1;
					i = i + 1;
				} else { // f[j] > x
							// swap f[j] with f[k-1]
					int temp;
					temp = f[j];
					f[j] = f[k - 1];
					f[k - 1] = temp;
					k = k - 1;
				}
			}
			quickSort(f, p, i);
			quickSort(f, j, q);
		}
	}

	static void mergeSort(int f[], int lb, int ub) {
		// termination reached when a segment of size 1 reached - lb+1 = ub
		if (lb + 1 < ub) {
			int mid = (lb + ub) / 2;
			mergeSort(f, lb, mid);
			mergeSort(f, mid, ub);
			merge(f, lb, mid, ub);
		}
	}

	static void merge(int f[], int p, int q, int r) {
		// p<=q<=r
		int i = p;
		int j = q;
		// use temp array to store merged sub-sequence
		int temp[] = new int[r - p];
		int t = 0;
		while (i < q && j < r) {
			if (f[i] <= f[j]) {
				temp[t] = f[i];
				i++;
				t++;
			} else {
				temp[t] = f[j];
				j++;
				t++;
			}
		}
		// tag on remaining sequence
		while (i < q) {
			temp[t] = f[i];
			i++;
			t++;
		}
		while (j < r) {
			temp[t] = f[j];
			j++;
			t++;
		}
		// copy temp back to f
		i = p;
		t = 0;
		while (t < temp.length) {
			f[i] = temp[t];
			i++;
			t++;
		}
	}

	static boolean isSorted(int k[]) {
		for (int j = 0; j < k.length - 1; j++)
			if (k[j] > k[j + 1])
				return false;
		return true;
	}
}