package info.christianbatista.validation;

public class NumericValidation {
	
	
	public static Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		// BR 16,50 US 12.04
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}
	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}