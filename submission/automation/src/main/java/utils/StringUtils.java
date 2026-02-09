package utils;

public final class StringUtils {
	
	public static String formatProductName(String productName) {
	    return productName
	            .toLowerCase()
	            .trim()
	            .replace(" ", "-")
	            .replace("(", "")
	            .replace(")", "");
	}

}
