package com.sapient.feeCalculator;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		new TransactionProcessor().generateReport(FileFormat.CSV, "InputDataFile.csv").forEach(System.out::println);
	}
}
