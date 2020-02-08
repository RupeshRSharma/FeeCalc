/**
 * 
 */
package com.sapient.feeCalculator;

import java.util.Comparator;
import java.util.List;

/**
 * @author rupesh sharma
 *
 */
public class TransactionFeeCalculator {

	private static final long TEN = 10;
	private static final long FIFTY = 50;
	private static final long HUNDRED = 100;
	private static final long FIVE_HUNDRED = 500;
	private static final String BUY = "BUY";
	private static final String SELL = "SELL";
	private static final String DEPOSIT = "DEPOSIT";
	private static final String WITHDRAW = "WITHDRAW";

	public void calculateFee(List<Transaction> transactions) {

		transactions.forEach(transaction -> {
			if (isIntradayTransaction(transaction, transactions)) {
				transaction.setProcessingFee(TEN);
			} else {
				if ("Y".equalsIgnoreCase(transaction.getPriority())) {
					transaction.setProcessingFee(FIVE_HUNDRED);
				} else {
					if (SELL.equalsIgnoreCase(transaction.getTransactionType())
							|| WITHDRAW.equalsIgnoreCase(transaction.getTransactionType())) {
						transaction.setProcessingFee(HUNDRED);
					} else if (BUY.equalsIgnoreCase(transaction.getTransactionType())
							|| DEPOSIT.equalsIgnoreCase(transaction.getTransactionType())) {
						transaction.setProcessingFee(FIFTY);
					}
				}
			}

		});

		transactions.sort(Comparator.comparing(Transaction::getClientId).thenComparing(Transaction::getTransactionType)
				.thenComparing(Transaction::getTransactionDate).thenComparing(Transaction::getPriority));

	}

	private boolean isIntradayTransaction(Transaction other, List<Transaction> transactions) {

		for (Transaction transaction : transactions) {
			if (transaction.getClientId().equals(other.getClientId())
					&& transaction.getSecurityId().equals(other.getSecurityId())
					&& transaction.getTransactionDate().equals(other.getTransactionDate())) {
				if ((BUY.equalsIgnoreCase(transaction.getTransactionType())
						&& SELL.equalsIgnoreCase(other.getTransactionType()))
						|| (SELL.equalsIgnoreCase(transaction.getTransactionType())
								&& BUY.equalsIgnoreCase(other.getTransactionType()))) {
					return true;
				}
			}
		}

		return false;
	}

}
