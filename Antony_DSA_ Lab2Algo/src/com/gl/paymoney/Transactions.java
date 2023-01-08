package com.gl.paymoney;

import java.util.Scanner;

public class Transactions {
	/*
	 * findTarget function - array as a parameter
	 */

	public static void findTarget(int arr[], long target) {
		int flag = 0;

		long sum = 0;
		int size = arr.length;
		for (int i = 0; i < size; i++) {

			sum += arr[i];

			if (sum >= target) {

				System.out.println("Target achieved after " + (i + 1) + " transactions ");

				flag = 1;

				break;

			}

		}

		if (flag == 0) {

			System.out.println(" Given target is not achieved ");
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of transaction array");

		int size = sc.nextInt();

		int arr[] = new int[size];

		System.out.println("Enter the values of array");

		for (int i = 0; i < size; i++)
			arr[i] = sc.nextInt();

		System.out.println("Enter the total no of targets that needs to be achieved");

		int targetNo = sc.nextInt();
		long target;

		// Based on number of targets
		// loops through different target value
		while (targetNo != 0) {
			System.out.println("Enter the value of target");
			target = sc.nextInt();

			findTarget(arr, target);
			targetNo--;
		}

		sc.close();
	}

}
