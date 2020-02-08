/**
 * 
 */
package com.sapient.feeCalculator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rupesh sharma
 *
 */
public class TransactionUtil {
	
	public static Transaction getTransaction(String[] transactionAttributes) {
        Transaction transaction = new Transaction();
        transaction.setExternalTransactionId(transactionAttributes[0]);
        transaction.setClientId(transactionAttributes[1]);
        transaction.setSecurityId(transactionAttributes[2]);
        transaction.setTransactionType(transactionAttributes[3]);
        transaction.setTransactionDate(parseDate(transactionAttributes[4]));
        transaction.setMarketValue(transactionAttributes[5]);
        transaction.setPriority(transactionAttributes[6]);
        return transaction;
    }

	public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy").parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
