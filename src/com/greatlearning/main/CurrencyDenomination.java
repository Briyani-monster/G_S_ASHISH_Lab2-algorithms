package com.greatlearning.main;

import java.util.Arrays;

import java.util.Scanner;

public class CurrencyDenomination {
	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the size of currency denominations");
		int size = sc.nextInt();
		int currencyDemonition[] = new int[size];
		System.out.println("Enter the currency denominations value");
		for (int index = 0; index < size; index++) {
			currencyDemonition[index] = sc.nextInt();
		}
		System.out.println("Enter the amount you want to pay");
		int ammount = sc.nextInt();

		// MergeSort Class Object
		MergeSort mergesort = new MergeSort();
		mergesort.sort(currencyDemonition, 0, size - 1);

		
		int noOfNotes[] = new int[size];
		noOfNotes=notesCounter(size, currencyDemonition, ammount);
		printNotesRquired(size, currencyDemonition, noOfNotes);
	}

	private static void printNotesRquired(int size, int[] currencyDemonition, int[] noOfNotes) {
		/**
		 * Print the currencies with there number of notes
		 */
		System.out.println("Notes are");
		for (int index = 0; index < size; index++) {
			if (noOfNotes[index] != 0) {
				System.out.println(currencyDemonition[index] + " : " + noOfNotes[index]);
			}

		}
	}

	private static int[] notesCounter(int size, int[] currencyDemonition, int ammount) {
		/**
		 * Getting count of the value from end of the Notes
		 */
		int noOfNotes[] = new int[size];
		for (int index = 0; index < size; index++) {
			noOfNotes[index] = ammount / currencyDemonition[index];
			ammount %= currencyDemonition[index];
		}
		if(ammount>0) {
			System.out.println("The target ammount is not reachable");
			return new int[size];
		}else 
			return noOfNotes;
	}
}
