package org.sdrc.boot.web.util;

public class TestUtil {

	  public static String createStringWithLength(int length) {
	        StringBuilder builder = new StringBuilder();
	 
	        for (int index = 0; index < length; index++) {
	            builder.append("x");
	        }
	 
	        return builder.toString();
	    }
}