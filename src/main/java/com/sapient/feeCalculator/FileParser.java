/**
 * 
 */
package com.sapient.feeCalculator;

import java.util.List;

/**
 * @author rupesh sharma
 *
 */
public interface FileParser {

	List<Transaction> parseFile(String path);
	
}
