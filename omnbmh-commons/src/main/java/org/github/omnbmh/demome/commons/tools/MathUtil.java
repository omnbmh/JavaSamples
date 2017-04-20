 

package org.github.omnbmh.demome.commons.tools;

import java.math.BigDecimal;
import java.math.BigInteger;

 

public class MathUtil {
	public static BigDecimal getBigDecimal(Object value) {
		BigDecimal ret = null;
		if (value != null) {
			if (value instanceof BigDecimal) {
				ret = (BigDecimal) value;
			} else if (value instanceof String) {
				ret = new BigDecimal((String) value);
			} else if (value instanceof BigInteger) {
				ret = new BigDecimal((BigInteger) value);
			} else if (value instanceof Number) {
				ret = new BigDecimal(((Number) value).doubleValue());
			} else {
				throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
			}
		}
		return ret;
	}
	
	 
	public static BigDecimal subtract(BigDecimal num1, BigDecimal num2) {
		return subtract(num1, num2,2);
	}
	
	public static BigDecimal subtract(BigDecimal num1, BigDecimal num2, int scale) {
		return num1.subtract(num2).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}
}
