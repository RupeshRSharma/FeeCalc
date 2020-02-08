/**
 * 
 */
package com.sapient.feeCalculator;

import java.util.Comparator;
import java.util.Date;

/**
 * @author rupesh sharma
 *
 */
public class Transaction implements Comparator<Transaction> {

	private String externalTransactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private Date transactionDate;
	private String marketValue;
	private String priority;
	private Long processingFee;

	/**
	 * @return the externalTransactionId
	 */
	public String getExternalTransactionId() {
		return externalTransactionId;
	}

	/**
	 * @param externalTransactionId the externalTransactionId to set
	 */
	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the securityId
	 */
	public String getSecurityId() {
		return securityId;
	}

	/**
	 * @param securityId the securityId to set
	 */
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the marketValue
	 */
	public String getMarketValue() {
		return marketValue;
	}

	/**
	 * @param marketValue the marketValue to set
	 */
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return the transactionFees
	 */
	public Long getProcessingFee() {
		return processingFee;
	}

	/**
	 * @param transactionFees the transactionFees to set
	 */
	public void setProcessingFee(Long processingFee) {
		this.processingFee = processingFee;
	}

	@Override
	public int compare(Transaction transaction1, Transaction transaction2) {

		int value1 = transaction1.getClientId().compareTo(transaction2.getClientId());
		if (value1 == 0) {
			int value2 = transaction1.getTransactionType().compareTo(transaction2.getTransactionType());
			if (value2 == 0) {
				int value3 = transaction1.getTransactionDate().compareTo(transaction2.getTransactionDate());
				if (value3 == 0) {
					return transaction1.getPriority().compareTo(transaction2.getPriority());
				} else {
					return value3;
				}

			} else {
				return value2;
			}
		}
		return value1;

	}

	@Override
	public String toString() {
		return "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
				+ "\nTransaction [externalTransactionID=" + externalTransactionId + "\t| clientId=" + clientId
				+ "\t| securityId=" + securityId + "\t| transactionType=" + transactionType + "\t| transactionDate="
				+ transactionDate + "\t| marketValue=" + marketValue + "\t| priority=" + priority
				+ "\t| transactionFees=" + processingFee + "]";
	}

}
