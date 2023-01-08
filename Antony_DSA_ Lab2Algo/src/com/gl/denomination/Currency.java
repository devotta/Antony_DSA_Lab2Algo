package com.gl.denomination;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Currency {
	/*
	 * denomination function accepts two parameters- amount, denominators returns
	 * qoutient
	 */
	public static int denomination(int amount, int denominator) {
		int qoutient = amount / denominator;
		return qoutient;
	}

	/*
	 * printnotes function accepts two parameters-amount & array to print the notes
	 */

	public static void merge(int arr[], int left, int mid, int right) {

		int len1 = mid - left + 1;
		int len2 = right - mid;

		int leftArr[] = new int[len1];
		int rightArr[] = new int[len2];

		for (int i = 0; i < len1; i++)
			leftArr[i] = arr[left + i];
		for (int j = 0; j < len2; j++)
			rightArr[j] = arr[mid + 1 + j];

		int i, j, k;
		i = 0;
		j = 0;
		k = left;

		while (i < len1 && j < len2) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while (i < len1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < len2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

	// Merge sort recursively called left half & right half of an array
	public static void mergeSort(int arr[], int left, int right) {
		if (left < right) {

			int mid = (left + right) / 2;

			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);

			merge(arr, left, mid, right);
		}
	}

	/*
	 * printnotes function Uses the merge sort function to sort array in ascending
	 * order and takes values in reverse order
	 */

	public static void printnotes(int amount, int arr[]) {
		int notes = 0;
		// Arrays.sort(arr);
		mergeSort(arr, 0, arr.length - 1);

		int size = arr.length;
		String[] notesArray = new String[size];
		int count = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			notes = denomination(amount, arr[i]);
			if (notes > 0) {
				// count the notes and store it an array
				count++;
				notesArray[count] = arr[i] + ":" + notes;
				amount = amount - notes * arr[i];
			}

		}
		// if amount==0 print all the chosen denomination
		// if not equal to display
		if (amount == 0) {
			for (int i = 0; i <= count; i++)
				System.out.println(notesArray[i]);
		} else {
			System.out.println("Not possible with the available denomination(s)");
		}

	}

	// Driver code
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of currency denominations");
		int size = sc.nextInt();
		int arr[] = new int[size];
		// Enter the currency denomination
		System.out.println("Enter the currency denominations value");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();

			// check for nonzero positive values
			if (arr[i] <= 0) {
				System.out.println("Enter the correct currency value (greater than 0)");
				i--;
			}
		}
		System.out.println("Enter the amount you want to pay");
		int amount = sc.nextInt();
		System.out.println("Your payment approach in order to give min no of notes will be");
		printnotes(amount, arr);
		sc.close();
	}

}
