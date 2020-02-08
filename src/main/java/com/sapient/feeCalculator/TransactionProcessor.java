/**
 * 
 */
package com.sapient.feeCalculator;

import java.util.List;

/**
 * @author rupesh sharma
 *
 */
public class TransactionProcessor {

	List<Transaction> generateReport(FileFormat format, String path) {

		FileParser parser = null;

		switch (format) {

		case CSV:
			parser = new CSVFileParser();
			break;
		case XML:
			new XMLFileParser();
			break;
		case EXCEL:
			new ExcelFileParser();
			break;
		case TEXT:
			new CSVFileParser();
			break;
		default:
			System.out.println("Invalid file format.");
			break;

		}

		if (parser != null) {
			List<Transaction> transactions = parser.parseFile(path);
			new TransactionFeeCalculator().calculateFee(transactions);
			return transactions;

		} else {
			return null;
		}

	}

}
