package br.com.erudio.util;

/**
 * 
 * @author Edilson
 *
 */
public class NumericUtil {

	/**
	 * 
	 * @param strNumber
	 * @return
	 */
	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) {
			return 0D;
		}
		
		if (isNumeric(strNumber)) {
			return Double.valueOf(strNumber);
		}
		
		return 0D;
	}

	/**
	 * 
	 * @param strNumber
	 * @return
	 */
	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) {
			return false;
		}
		
		return strNumber.matches("[+-]?([0-9]*[.])?[0-9]+");
	}
}
