/**
 * 
 */
package com.sapient.feeCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rupesh sharma
 *
 */
public class CSVFileParser implements FileParser {

	public List<Transaction> parseFile(String path) {

		String nextLine = "";
		String delimitter = ",";
		BufferedReader br = new BufferedReader(
				new InputStreamReader(CSVFileParser.class.getClassLoader().getResourceAsStream(path)));

		List<Transaction> transactions = new ArrayList<>();

		try {
			while ((nextLine = br.readLine()) != null) {
				transactions.add(TransactionUtil.getTransaction(nextLine.split(delimitter)));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return transactions;
	}

}
