package com.greatlearning.main;

import java.util.Scanner;

public class FindTargetTransaction {
	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the number of transaction per day");
		int size = sc.nextInt();
		int[] transactionsArray = new int[size];
		System.out.println("ENter the transaction now");
		for (int index = 0; index < size;) {
			int transaction = sc.nextInt();
			if (transaction > 0) {
				// discarding negative and zero
				transactionsArray[index] = transaction;
				index++;
			}
		}
		noofTransaction(transactionsArray);
		sc.close();
	}

	private static void noofTransaction(int[] transactionsArray) {
		System.out.println("Enter the total no of targets that needs to be achieved");
		int nooftargets = sc.nextInt();
		for (int index = 0; index < nooftargets; index++) {
			System.out.println("Enter the value of target");
			int target = sc.nextInt();
			int transactionCount = getNumberOfTransaction(transactionsArray, target);
			if (transactionCount == -1)
				System.out.println("Given target is not achieved");
			else
				System.out.println("Target achieved after " + (transactionCount+1) + " transactions");
		}
	}

	private static int getNumberOfTransaction(int[] transactionsArray, int target) {
		// we are doing running sum and every updated value of sum we are checking that
		// target acheived or not
		int sum = 0;
		int transactionCount = -1;
		for (int index = 0; index < transactionsArray.length; index++) {
			sum += transactionsArray[index];
			if (sum >= target) {
				transactionCount = index;
				break;
			}
		}

		return transactionCount;

	}
}
